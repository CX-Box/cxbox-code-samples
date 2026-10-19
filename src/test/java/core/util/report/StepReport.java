package core.util.report;

import java.util.Map;
import java.util.function.Consumer;
import core.element.widget.field.AbstractField;
import core.element.widget.modal.ErrorPopupException;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Parameter;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StatusDetails;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.util.ResultsUtils;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import static core.util.i18n.CoreMessageSource.message;

/**
 * The report in two levels. The first level reads as the scenario: what the user did and saw, with the values in the
 * names of the lines. One level deeper is everything a developer needs to find a problem: where the test looked for the
 * element, the service steps (the look up of a widget, the waits, the load of the page, the reads) and their start time.
 * <p>
 * A service step made right in a step of the scenario (a row taken before its fields are checked) is kept and goes under
 * the next line of the step, with the label «подготовка»; the ones made after the last line go under the step of the
 * scenario at its end, with the label «в конце шага». Nothing is read from the browser for the report.
 */
@UtilityClass
public class StepReport {

	private static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HH:mm:ss");

	/** The type and the name of a widget in the selectors of the core: {@code div[data-test-widget-type='List']} */
	private static final Pattern WIDGET_TYPE = Pattern.compile("data-test-widget-type=[\"']([^\"']+)[\"']");

	private static final StackWalker WALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

	/** The packages of the core of the tests and of the libraries: their frames are not the code of the tests */
	private static final Pattern LIBRARY = Pattern.compile("(core|coreoverride|io\\.qameta|java|javax|jdk|sun|org|com|lombok|net)\\.");

	private static final Pattern WIDGET_NAME = Pattern.compile("data-test-widget-name=[\"']([^\"']+)[\"']");

	/** The steps that run now, the inner one first: {@link StepReportListener} tells when they start and stop */
	private static final ThreadLocal<Deque<StepResult>> RUNNING = ThreadLocal.withInitial(ArrayDeque::new);

	/** The steps of the scenario among them: the lines started right in them are the first level of the report */
	private static final ThreadLocal<Set<StepResult>> SCENARIO_STEPS = ThreadLocal.withInitial(() -> Collections.newSetFromMap(new IdentityHashMap<>()));

	/** The service steps made right in a step of the scenario, waiting for the next line of the step */
	private static final ThreadLocal<List<StepResult>> PENDING = ThreadLocal.withInitial(ArrayList::new);

	/**
	 * The service steps without steps inside, by their result: the next equal one right after a step is not a line of its
	 * own, the step gets the number of them ({@link #repeated})
	 */
	private static final ThreadLocal<Map<StepResult, Service>> SERVICES = ThreadLocal.withInitial(IdentityHashMap::new);

	/** The field whose value line runs now: the reads of its value inside the line make no steps of their own */
	private static final ThreadLocal<AbstractField<?, ?, ?, ?>> VALUE_LINE = new ThreadLocal<>();

	/**
	 * A step of the scenario of a project, the first level of the report; the service steps made after its last line go
	 * under it at its end
	 */
	public static <T> T scenario(String name, Allure.ThrowableRunnable<T> body) {
		return Allure.step(name, () -> {
			var scenario = RUNNING.get().peek();
			SCENARIO_STEPS.get().add(scenario);
			try {
				return body.run();
			} finally {
				scenario.getSteps().addAll(take(message("report.stepEnd")));
				SCENARIO_STEPS.get().remove(scenario);
				SERVICES.get().clear();
			}
		});
	}

	/**
	 * Adds the value to the name of the current line: «Поле «Название»: вводит «Новый файл»»
	 */
	public static void value(Object value) {
		var text = text(value);
		Allure.getLifecycle().updateStep(step -> step.setName(step.getName() + " " + text));
	}

	/**
	 * A list read by the current line: the line gets the number of the values («7 вариантов»), the values are a text under
	 * it, one value a line, in the order on the screen. {@code kind} is the word of the values in the texts: options,
	 * columns.
	 */
	public static void list(Collection<String> values, String kind) {
		var shown = values.stream().filter(value -> !value.isBlank()).toList();
		count(shown.size(), kind);
		Allure.addAttachment(message("report." + kind + ".text"), "text/plain", String.join("\n", shown), ".txt");
	}

	/**
	 * Adds the number of the values to the name of the current line: «Список: просматривает 5 строк». {@code kind} is the
	 * word of the values in the texts: options, columns, rows.
	 */
	public static void count(int number, String kind) {
		var text = message(plural("report." + kind, number), number);
		Allure.getLifecycle().updateStep(step -> step.setName(step.getName() + " " + text));
	}

	/**
	 * A widget in the technical lines: «список ApplicationDocList (ищется по имени)», «форма «Новый период» (ищется по
	 * заголовку)». {@code type} is the type of the widget of the meta.
	 */
	public static String widget(String type, String identifier, boolean byName) {
		var kind = type.contains("Popup") ? "popup" : type.startsWith("List") ? "list" : type.startsWith("Form") ? "form"
				: type.startsWith("Info") ? "info" : "other";
		var shown = byName ? identifier : "«" + identifier + "»";
		return message("report.widget." + kind, type) + " " + shown + " (" + message(byName ? "report.byName" : "report.byTitle") + ")";
	}

	/**
	 * An element in the technical lines: a widget found by the selector of the core is told as the widget («список
	 * ApplicationDocList (ищется по имени)»), so the lines of one widget read the same; any other element by its selector
	 */
	public static String element(SelenideElement element) {
		var criteria = element.getSearchCriteria();
		var type = WIDGET_TYPE.matcher(criteria);
		if (!type.find()) {
			return criteria;
		}
		var name = WIDGET_NAME.matcher(criteria);
		return name.find() ? widget(type.group(1), name.group(1), true) : message("report.widget.popup", type.group(1)) + " " + type.group(1);
	}

	/** The key of the text for a number: one, few or many (1 вариант, 2 варианта, 5 вариантов) */
	private static String plural(String key, int number) {
		var tens = number % 100;
		var units = number % 10;
		if (units == 1 && tens != 11) {
			return key + ".one";
		}
		return units >= 2 && units <= 4 && (tens < 12 || tens > 14) ? key + ".few" : key + ".many";
	}

	/**
	 * A service step: one level deeper than the action it serves, with its start time in the name
	 */
	public static <T> T service(String name, Allure.ThrowableRunnable<T> body) {
		return run(name, body, false);
	}

	/**
	 * A service step that returns nothing
	 */
	public static void service(String name, Allure.ThrowableRunnableVoid body) {
		run(name, () -> {
			body.run();
			return null;
		}, false);
	}

	/**
	 * A service read: the value read goes to the name of the step («список ApplicationDocList: строка 1, id «1113883»»)
	 */
	public static <T> T read(String name, Allure.ThrowableRunnable<T> body) {
		return run(name, body, true);
	}

	/**
	 * A read of the value of a field. Read by the test, it is a line of the scenario with the same verb as a check
	 * ({@link #check}): the report does not show what the test checks, so it does not tell a read from a check. Read by the
	 * core inside an action, it is a service step of the action.
	 */
	@SneakyThrows
	public static <T> T read(AbstractField<?, ?, ?, ?> field, Allure.ThrowableRunnable<T> body) {
		if (VALUE_LINE.get() == field) {
			return body.run();
		}
		if (!scenarioLevel()) {
			return run(message("field.getValue", field.getFieldIdentifier()), body, true);
		}
		return valueLine(message("field.getValue", field.getFieldIdentifier()), field, body, value -> {
		});
	}

	/**
	 * A check of the value of a field. Made by the test, it is the line «Поле «Статус»: видит «Назначена»» with the check
	 * inside: a failed check marks the line. Made by the core inside an action, the read is a service step of the action.
	 */
	@SneakyThrows
	public static <T> void check(AbstractField<?, ?, ?, ?> field, Allure.ThrowableRunnable<T> read, Consumer<T> check) {
		if (!scenarioLevel()) {
			check.accept(read.run());
			return;
		}
		valueLine(message("field.checkValue", field.getFieldIdentifier()), field, read, check);
	}

	private static <T> T valueLine(String name, AbstractField<?, ?, ?, ?> field, Allure.ThrowableRunnable<T> read, Consumer<T> check) {
		return Allure.step(name, () -> {
			VALUE_LINE.set(field);
			T result;
			try {
				result = read.run();
			} finally {
				VALUE_LINE.remove();
			}
			value(result);
			check.accept(result);
			return result;
		});
	}

	/**
	 * A line of the developer that tells a decision of the core: «значение уже такое, нажатие не нужно»
	 */
	public static void note(String text) {
		Allure.step(text);
	}

	/**
	 * A step has started. A line of the first level takes the service steps made before it.
	 */
	static void started(StepResult step) {
		code(step);
		var running = RUNNING.get();
		if (firstLevel(running.peek()) && !PENDING.get().isEmpty()) {
			step.getSteps().addAll(0, take(message("report.beforeLine")));
		}
		running.push(step);
	}

	/** A step has stopped */
	static void stopped(StepResult step) {
		RUNNING.get().removeIf(running -> running == step);
		explainFailure(step);
		var parent = RUNNING.get().peek();
		if (parent != null) {
			repeated(parent.getSteps(), step);
		}
	}

	/**
	 * A failed step with an error popup of the application on the screen: the popup covers the page, and the failure of
	 * Selenium tells only that an element is covered or not found. The text of the popup goes first into the failure of
	 * the step. The browser is read only for a failed step, once: by the innermost one, its parents fail with it
	 */
	private static void explainFailure(StepResult step) {
		if (step.getStatus() != Status.FAILED && step.getStatus() != Status.BROKEN
				|| step.getSteps().stream().anyMatch(child -> child.getStatus() == Status.FAILED || child.getStatus() == Status.BROKEN)
				|| !WebDriverRunner.hasWebDriverStarted()) {
			return;
		}
		try {
			var popup = Selenide.$(ErrorPopupException.SELECTOR);
			if (!popup.exists()) {
				return;
			}
			var text = message("report.errorPopup", popup.getText().replaceAll("\\s+", " ").strip());
			var details = step.getStatusDetails() == null ? new StatusDetails() : step.getStatusDetails();
			if (details.getMessage() != null && details.getMessage().startsWith(text)) {
				// the step stopped on the popup itself (ErrorPopupException): its failure tells the popup already
				return;
			}
			step.setStatusDetails(details.setMessage(details.getMessage() == null ? text : text + "\n" + details.getMessage()));
		} catch (RuntimeException e) {
			// the browser may be gone with the failure: the failure stays as it is
		}
	}

	/**
	 * A service step that has just ended, the last of its {@code siblings}: when the step before it is the same service
	 * step (same name, nothing inside, both passed), it is not a line of its own, the step before gets the number
	 * («Обращение к виджету: форма X — …, 2 раза, начало 12:50:04»). The time is of the first one.
	 */
	private static void repeated(List<StepResult> siblings, StepResult step) {
		var services = SERVICES.get();
		var service = services.get(step);
		if (service == null || siblings.size() < 2 || siblings.get(siblings.size() - 1) != step) {
			return;
		}
		var before = siblings.get(siblings.size() - 2);
		var first = services.get(before);
		if (first == null || !first.name().equals(service.name()) || !step.getSteps().isEmpty() || !before.getSteps().isEmpty()
				|| step.getStatus() != Status.PASSED || before.getStatus() != Status.PASSED) {
			return;
		}
		siblings.remove(siblings.size() - 1);
		services.remove(step);
		var count = first.count() + 1;
		services.put(before, new Service(first.name(), first.time(), count));
		before.setName(first.name() + ", " + message(plural("report.times", count), count) + ", " + first.time()).setStop(step.getStop());
	}

	/** A service step: its name without the time, the time of its start and how many equal steps in a row it is */
	private record Service(String name, String time, int count) {
	}

	/** The service steps kept so far, each with the label of where it was made */
	private static List<StepResult> take(String label) {
		var pending = PENDING.get();
		var steps = pending.stream().map(step -> step.setName(label + " " + step.getName())).toList();
		pending.clear();
		return steps;
	}

	@SneakyThrows
	private static <T> T run(String name, Allure.ThrowableRunnable<T> body, boolean showResult) {
		var time = message("report.start", TIME.format(LocalDateTime.now()));
		if (!scenarioLevel()) {
			return Allure.step(name + ", " + time, () -> {
				var self = RUNNING.get().peek();
				var result = body.run();
				var shown = showResult ? name + " " + text(result) : name;
				self.setName(shown + ", " + time);
				SERVICES.get().put(self, new Service(shown, time, 1));
				return result;
			});
		}
		var step = new StepResult().setName(name + ", " + time).setStart(System.currentTimeMillis());
		code(step);
		var pending = PENDING.get();
		pending.add(step);
		try {
			var result = body.run();
			var shown = showResult ? name + " " + text(result) : name;
			step.setName(shown + ", " + time).setStatus(Status.PASSED);
			SERVICES.get().put(step, new Service(shown, time, 1));
			return result;
		} catch (Throwable e) {
			step.setStatus(ResultsUtils.getStatus(e).orElse(Status.BROKEN)).setStatusDetails(ResultsUtils.getStatusDetails(e).orElse(null));
			throw e;
		} finally {
			step.setStop(System.currentTimeMillis());
			repeated(pending, step);
		}
	}

	/**
	 * The line of the code of the tests that made the step and the lines that called it, in its parameter «Код»:
	 * «CheckListAdminViewPageObject.java:41 ← S01CreateApplicationVkTest.java:93 ← 90». From any line of the report the reader
	 * goes to the place of the test it came from (the first place is ready for «Go to file» of IDEA) and sees the way to it
	 * from the scenario, also through a page object or a helper method. The code of the tests is the code outside the core of
	 * the tests and the libraries; the abstract root of the tests (the helpers of the steps and the sign in) is skipped: its
	 * lines belong to the place of the test that calls it. An abstract scenario with the steps of several tests (S21) is the
	 * code of the tests. A file is named once for its lines in a row.
	 */
	private static void code(StepResult step) {
		var places = WALKER.walk(frames -> frames.filter(frame -> !LIBRARY.matcher(frame.getClassName()).lookingAt()
						&& !root(frame.getDeclaringClass()))
				.map(frame -> frame.getFileName() + ":" + frame.getLineNumber())
				.toList());
		var code = new StringBuilder();
		String last = null;
		for (var place : places) {
			if (place.equals(last)) {
				continue;
			}
			var file = place.substring(0, place.lastIndexOf(':') + 1);
			code.append(last == null ? "" : " ← ").append(last != null && last.startsWith(file) ? place.substring(file.length()) : place);
			last = place;
		}
		if (!code.isEmpty()) {
			step.getParameters().add(new Parameter().setName(message("report.code")).setValue(code.toString()));
		}
	}

	/** The abstract root of the tests: its frames are the helpers of the steps and the sign in */
	private static boolean root(Class<?> type) {
		return Modifier.isAbstract(type.getModifiers()) && type.getSuperclass() == Object.class;
	}

	/** Right in a step of the scenario or in the test out of its steps, not inside an action of the core */
	private static boolean scenarioLevel() {
		return Allure.getLifecycle().getCurrentTestCaseOrStep().isPresent() && firstLevel(RUNNING.get().peek());
	}

	/** A step started in this parent is a line of the first level; no parent is the test itself */
	private static boolean firstLevel(StepResult parent) {
		return parent == null || SCENARIO_STEPS.get().contains(parent);
	}

	/** A value in the name of a line: «30.10.2026»; no value is «(пусто)» without the quotes, not the «null» of Java */
	private static String text(Object value) {
		return value == null || value instanceof String string && string.isEmpty() ? message("report.empty") : "«" + plain(value) + "»";
	}

	private static String plain(Object value) {
		if (value instanceof LocalDate date) {
			return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		}
		if (value instanceof LocalDateTime dateTime) {
			return dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
		}
		if (value instanceof Boolean flag) {
			return message(flag ? "report.yes" : "report.no");
		}
		if (value instanceof File file) {
			return file.getName();
		}
		if (value instanceof Collection<?> values) {
			return values.stream().map(StepReport::plain).collect(Collectors.joining(", "));
		}
		return String.valueOf(value);
	}

}
