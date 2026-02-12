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

public class FileUploadRO<W extends AbstractWidget<ExpectationPattern, W>> extends AbstractFieldImpl<ExpectationPattern, W, File, FileUploadRO<W>> implements
		PlaceholderSupportedCheckable<W, File, FileUploadRO<W>>,
		ColorSupportedCheckable<W, File, FileUploadRO<W>>,
		ReadOnlyCheckable<W, File, Boolean, FileUploadRO<W>>,
		DrillDownSupportCheckable<W, File, Boolean, FileUploadRO<W>>,
		ValueCheckable<W, File, FileUploadRO<W>> {

	private final String identifier;

	public FileUploadRO(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.identifier = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.FILE_UPLOAD_RO;
	}

	@Override
	public File getValue() {
		return element().$("button").download(DownloadOptions.using(FOLDER));
	}

	@Override
	public FileUploadRO<W> setValue(File value) {
		return null;
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public SelenideElement element() {
		return widget().element().
				$$("div[data-test-field-type='" + fieldType().getType() + "'][data-test-field-title=\"" + identifier + "\"]")
				.get(0)
				.scrollIntoView("{block: \"center\"}")
				.shouldBe(Condition.enabled, widget().getExpectations().getTimeout());
	}

	public FileUploadRO<W> checkFileName(Consumer<String> value) {
		value.accept(getValue().getName());
		return this;
	}

	public FileUploadRO<W> checkFileNameInField(Consumer<String> value) {
		return Allure.step("Getting the file name in the field", step -> {
			logTime(step);
			value.accept(element()
					.$(valueTag())
					.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
					.text());
			return this;
		});
	}
}
