package core.element.widget.action;

import core.util.report.StepReport;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.WebDriverConditions.url;

import static com.codeborne.selenide.Selenide.webdriver;

import java.util.List;
import com.codeborne.selenide.ElementsCollection;
import static core.util.i18n.CoreMessageSource.message;

import io.qameta.allure.Allure;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DownloadOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.File;
import java.time.Duration;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

// TODO add to burger and check logic
@Slf4j
public class Action<W extends AbstractWidget<ExpectationPattern, W>> implements SingleElement {

	@Getter(AccessLevel.PROTECTED)
	private final W widget;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	protected Action<W> parent;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	protected Action<W> current;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private String name;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private String iconName;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private Predicate<SelenideElement> condition;

	public Action(W widget) {
		this.widget = widget;
		this.parent = null;
	}

	@SneakyThrows
	public Action<W> action(String name) {
		Action<W> wAction = new Action<>(this.widget);
		wAction.setParent(current);
		wAction.setName(name);
		wAction.setCurrent(wAction);
		wAction.setCondition(el-> el.getText().equals(name));
		return wAction;
	}

	@SneakyThrows
	public Action<W> action(String name, String iconName) {
		Action<W> wAction = new Action<>(this.widget);
		wAction.setParent(current);
		wAction.setName(name);
		wAction.setIconName(iconName);
		wAction.setCurrent(wAction);
		wAction.setCondition(el-> el.getText().equals(name) && el.$(By.cssSelector("i[aria-label='icon: " + iconName + "']")).isDisplayed());
		return wAction;
	}

	@SneakyThrows
	public Action<W> actionWithIcon(String iconName) {
		Action<W> wAction = new Action<>(this.widget);
		wAction.setParent(current);
		wAction.setIconName(iconName);
		wAction.setCurrent(wAction);
		wAction.setCondition(el-> el.$(By.cssSelector("i[aria-label='icon: " + iconName + "']")).isDisplayed() );
		return wAction;
	}


	public W click() {
		Action<W> currentAction = this.current;
		PageRequests.track();
		if (this.parent == null) {
			currentAction.element().click();
			waitOperationFinished();
			return this.widget;
		}
		log.warn("Action parent: {} {} , action: {} {}", this.parent.name, this.parent.iconName, this.name, this.iconName);
		//click parent action;
		currentAction.parent.element().click();
		currentAction.element().click();
		waitOperationFinished();
		return widget;
	}

	/**
	 * The operation is finished when its requests are done and rendered (a popup widget has no loading spinner) and the
	 * widget has no loading spinner. A widget that is gone after the operation (a drilldown, a closed popup) has nothing to wait for.
	 * The requests wait is temporary until the popup widgets show the loading spinner ({@link PageRequests}).
	 */
	private void waitOperationFinished() {
		PageRequests.waitDone(widget.getExpectations().getOverTimeout());
		Selenide.Wait().withTimeout(widget.getExpectations().getOverTimeout()).until(driver -> {
			try {
				// the widget that is gone is not looked for: the look up waits for it the whole timeout
				return !widget.isOnPage() || !widget.element().$(".ant-spin-spinning").exists();
			} catch (RuntimeException | AssertionError e) {
				return true;
			}
		});
	}

	/**
	 * Clicks the action that opens another view (the action returns a drillDown) and waits until the address of the page
	 * is changed, as the drilldown of a field does: {@link #click()} waits for the requests and the spinner of the widget,
	 * and the old widget can stay on the page without a spinner until the new view comes.
	 */
	public void clickWithDrilldown() {
		var oldUrl = WebDriverRunner.url();
		if (getParent() != null) {
			getParent().element().click();
		}
		element().click();
		webdriver().shouldNotHave(url(oldUrl), getWidget().getExpectations().getTimeout());
	}

	/** {@link #clickWithDrilldown()} of the button with the name */
	public void clickWithDrilldown(String name) {
		Allure.step(message("action.clickIn", name, widget.label()), () -> {
			action(name).clickWithDrilldown();
		});
	}

	public W click(String name) {
		Allure.step(message("action.clickIn", name, widget.label()), () -> {
			action(name).click();
		});
		return this.widget;
	}

	/**
	 * Clicks the action that gives a file and returns the downloaded file.
	 * <p>
	 * The file is taken the same way as from a file field ({@code FileUpload.getValue}).
	 */
	@SneakyThrows
	public File download(String name) {
		return Allure.step(message("action.download", name, widget.label()), () -> action(name).element().download(DownloadOptions.using(FOLDER)));
	}

	/**
	 * The button of the action that chooses files ({@code subtype multiFileUpload}) gets the files, as the user chooses
	 * them in the window of the browser. Waits until the uploaded files come to the widget.
	 */
	public W upload(String name, File... files) {
		Allure.step(message("action.upload", name, widget.label()), () -> {
			StepReport.value(Stream.of(files).map(File::getName).toList());
			uploadAndWait(action(name).element().closest(".ant-upload").$("input[type='file']"), files);
		});
		return this.widget;
	}

	/**
	 * The zone above the panel of the widget ({@code mode file-upload-dnd} of the button) gets the files, as the user
	 * drops them on it. Waits until the uploaded files come to the widget.
	 */
	public W uploadToDropZone(File... files) {
		Allure.step(message("action.uploadToDropZone", widget.label()), () -> {
			StepReport.value(Stream.of(files).map(File::getName).toList());
			uploadAndWait(widget.element().$(".ant-upload-drag input[type='file']"), files);
		});
		return this.widget;
	}
	public W setValue(File... files) {
		if (parent != null) {
			throw new UnsupportedOperationException("setValue supports top level actions only");
		}
		return Allure.step("Uploading the files with the action \"" + name + "\"", step -> {
			AbstractWidget.logTime(step);
			SelenideElement input = element().closest(".ant-upload").$("input[type='file']");
			// the files are uploaded one by one, then the widget sends them with associate and reads the records again
			PageRequests.runAndWaitDelayedRequests(() -> input.uploadFile(files),
					widget.getExpectations().getTimeout(), widget.getExpectations().getOverTimeout());
			waitOperationFinished();
			return widget;
		});
	}

	/**
	 * The files go one by one, each with its line in the window of the upload progress; when the last one is done, the
	 * widget sends the records of the files. The wait is for the end of every line, then for these requests.
	 */
	private void uploadAndWait(SelenideElement input, File... files) {
		var timeout = widget.getExpectations().getOverTimeout();
		// a request for each file, then one request makes the records of all the files: the widget sends it after a render,
		// when the last file is done, so the requests are counted
		PageRequests.runAndWaitRequests(() -> {
			input.uploadFile(files);
			for (var file : files) {
				var line = $("[data-test-file-upload-prgress-item='true'][data-test-file-name='" + file.getName() + "']");
				line.shouldNotHave(Condition.attributeMatching("data-test-file-status", "init|uploading"), timeout);
				line.shouldHave(Condition.attribute("data-test-file-status", "done").because(line.getAttribute("data-test-file-status-information")));
			}
		}, files.length + 1, timeout);
		waitOperationFinished();
	}
	@Override
	public SelenideElement element() {
		Duration timeout = this.widget.getExpectations().getTimeout();
		Stream<SelenideElement> stream = null;
		if (parent == null) {
			stream = buttons()
					.shouldHave(CollectionCondition.sizeGreaterThan(0), timeout)
					.asFixedIterable().stream();
		}else{
			stream = widget.element()
					.$("div[class*='Operations__operations']")
					.$("div[class*='OperationsGroup__overlayContainer']")
					.shouldBe(Condition.visible, timeout)
					.$$("li[data-test-widget-action-item='true'] div.ant-spin-container")
					.shouldHave(CollectionCondition.sizeGreaterThan(0), timeout)
					.asFixedIterable().stream();
		}

		return stream
				.filter(this.condition)
				.findFirst()
				.orElseThrow(() -> new NoSuchElementException("No such element"));
	}


	/** The buttons of the panel of the widget */
	protected ElementsCollection buttons() {
		return widget.element().$("div[class*='Operations__operations']").$$("button");
	}

	/** The texts of the visible buttons of the panel */
	public List<String> names() {
		return Allure.step(message("action.names"), () -> {
			var names = buttons()
					.shouldHave(CollectionCondition.sizeGreaterThan(0), widget.getExpectations().getTimeout())
					.filterBy(Condition.visible)
					.texts();
			StepReport.value(names);
			return names;
		});
	}

	public W checkExistActionsBlocks() {
		widget.element()
				.findAll(by("type", "button"))
				.shouldBe(CollectionCondition.sizeGreaterThan(0));
		return this.widget;
	}


}
