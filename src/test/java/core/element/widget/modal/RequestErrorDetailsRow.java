package core.element.widget.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.expectation.ExpectationPattern;
import core.page.Sidebar;
import io.qameta.allure.Allure;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

/**
 * The row every error popup has under its message: the "Copy details" link and the arrow that expands the request details on screen.
 * Shared by {@link ErrorPopup} and {@link SignInAgainPopup}.
 */
@RequiredArgsConstructor
class RequestErrorDetailsRow {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * How the screen formats the ISO dates of the JSON (in the browser time zone, which is the machine time zone)
	 */
	private static final DateTimeFormatter SHOWN_DATE = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS");

	private static final DateTimeFormatter ISO_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);

	private final SelenideElement popup;

	private final ExpectationPattern expectations;

	/**
	 * "Copy details": puts the details on the clipboard as JSON and reads them back the way a user does, by pasting into a text input
	 */
	ErrorDetails copy() {
		return Allure.step("Copy details", step -> {
			logTime(step);
			popup.$("[data-test-request-error-details-button-copy]").shouldBe(Condition.visible, expectations.getTimeout()).click();
			$(".ant-message .ant-message-success").shouldBe(Condition.visible, expectations.getTimeout());
			return parse(new Sidebar().readClipboard());
		});
	}

	/**
	 * The arrow: expands the details on screen (leaves them expanded when they already are) and reads them.
	 * "status code + status text" and "method + url" are split, the dates converted back to ISO.
	 */
	RequestDetails expand() {
		return Allure.step("Expand details", step -> {
			logTime(step);
			if (!value("sessionId").is(Condition.visible)) {
				popup.$("[data-test-request-error-details-button-toggle]").shouldBe(Condition.visible, expectations.getTimeout()).click();
			}
			var status = text("status").split(" ", 2);
			var request = text("request").split(" ", 2);
			return new RequestDetails(
					text("sessionId"),
					status[0].matches("\\d+") ? Integer.valueOf(status[0]) : null,
					status.length > 1 ? status[1] : null,
					request[0],
					request.length > 1 ? request[1] : null,
					toIso(text("startedAt")),
					toIso(text("finishedAt"))
			);
		});
	}

	@SneakyThrows
	private static ErrorDetails parse(String json) {
		return objectMapper.readValue(json, ErrorDetails.class);
	}

	private static String toIso(String shownDate) {
		return ISO_DATE.format(LocalDateTime.parse(shownDate, SHOWN_DATE).atZone(ZoneId.systemDefault()).toInstant());
	}

	private String text(String name) {
		return value(name).shouldBe(Condition.visible, expectations.getTimeout()).getText();
	}

	private SelenideElement value(String name) {
		return popup.$("[data-test-request-error-details-value='" + name + "']");
	}

}
