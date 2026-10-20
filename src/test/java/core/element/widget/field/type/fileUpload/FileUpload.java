package core.element.widget.field.type.fileUpload;

import static core.element.PlatformApp.config;
import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

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
import java.util.regex.Pattern;
import java.util.function.Consumer;

import static com.codeborne.selenide.FileDownloadMode.FOLDER;

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
		return Allure.step(message("field.download", getFieldIdentifier()), step -> {
			return element().$(config().selectors.fileUploadFile).download(DownloadOptions.using(FOLDER));
		});
	}

	@Override
	public SELF setValue(File value) {
		return Allure.step(message("field.upload", getFieldIdentifier()), step -> {
			StepReport.value(value.getName());
			element().$(valueTag()).uploadFile(value);
			// a long name is shown shortened in the middle, the title of the link keeps the whole name
			element()
					.$("[class*='downloadLink'][title]")
					.shouldHave(Condition.attributeMatching("title", ".* " + Pattern.quote(value.getName())), widget().getExpectations().getTimeout());
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
		return Allure.step(message("field.fileName", getFieldIdentifier()), step -> {
			value.accept(element()
					.$(valueTag())
					.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
					.text());
			return (SELF) this;
		});
	}

	public String getFileNameInField() {
		return Allure.step(message("field.fileName", getFieldIdentifier()), step -> {
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
		return Allure.step(message("field.deleteFile", getFieldIdentifier()), step -> {
			element().$("i[title=\"Delete\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();
			element()
					.$(config().selectors.fileUploadFile)
					.shouldNot(Condition.exist, widget().getExpectations().getTimeout());
			return (SELF) this;
		});
	}

	public SELF checkNoFileInField() {
		return Allure.step(message("field.noFile", getFieldIdentifier()), step -> {
			element()
					.$(config().selectors.fileUploadFile)
					.shouldNot(Condition.exist, widget().getExpectations().getTimeout());
			return (SELF) this;
		});
	}
}
