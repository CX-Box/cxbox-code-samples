package core.element.widget.field.type.fileUpload;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DownloadOptions;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.*;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.io.File;
import java.util.function.Consumer;

import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static core.element.widget.AbstractWidget.logTime;

public class FileUpload<W extends AbstractWidget<ExpectationPattern, W>, SELF extends FileUpload<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, File, SELF> implements
		PlaceholderSupportedCheckable<W, File, SELF>,
		PlaceholderCheckable<W, File, String, SELF>,
		ColorCheckable<W, File, String, SELF>,
		ReadOnlyCheckable<W, File, Boolean, SELF>,
		DrillDownSupportCheckable<W, File, Boolean, SELF>,
		RequiredCheckable<W, File, String, SELF>,
		ValueCheckable<W, File, SELF> {

	private final String identifier;

	public FileUpload(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.identifier = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.FILE_UPLOAD;
	}

	@Override
	public File getValue() {
		return element().$("button").download(DownloadOptions.using(FOLDER));
	}

	@Override
	public SELF setValue(File value) {
		return Allure.step("Uploading a file to the {value} field", step -> {
			logTime(step);
			step.parameter("File", value.getName());
			element().$(valueTag()).uploadFile(value);
			element()
					.$("button")
					.shouldHave(Condition.text(value.getName()), widget().getExpectations().getTimeout());
			return (SELF) this;
		});
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public SELF checkPlaceholder(Consumer<String> expectedPlaceholder) {
		expectedPlaceholder.accept(element().$("span[title=\"Placeholder text\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.text());
		return (SELF) this;
	}

	@Override
	public SELF checkReadOnly(Consumer<Boolean> expectedReadOnly) {
		expectedReadOnly.accept(element()
				.$("div.ant-upload-disabled")
				.exists());
		return (SELF) this;
	}

	public SELF checkFileName(Consumer<String> value) {
		value.accept(getValue().getName());
		return (SELF) this;
	}

	public SELF checkFileNameInField(Consumer<String> value) {
		return Allure.step("Getting the file name in the field", step -> {
			logTime(step);
			value.accept(element()
					.$(valueTag())
					.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
					.text());
			return (SELF) this;
		});
	}

	public String getFileNameInField() {
		return Allure.step("Getting the file name in the field", step -> {
			logTime(step);
			return element()
					.$(valueTag())
					.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
					.text();
		});
	}

	public FileUploadPopup<W, SELF> popup() {
		return new FileUploadPopup<>(widget().getExpectations(), (SELF) this);
	}

	public SELF clear() {
		return Allure.step("Clearing the field. Deleting a file.", step -> {
			logTime(step);
			element().$("i[title=\"Delete\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();
			element()
					.$("button")
					.shouldNot(Condition.exist, widget().getExpectations().getTimeout());
			return (SELF) this;
		});
	}

	public SELF checkNoFileInField() {
		return Allure.step("Assert that no file is present in the field", step -> {
			logTime(step);
			element()
					.$("button")
					.shouldNot(Condition.exist, widget().getExpectations().getTimeout());
			return (SELF) this;
		});
	}
}
