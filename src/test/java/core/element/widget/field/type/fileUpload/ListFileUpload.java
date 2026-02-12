package core.element.widget.field.type.fileUpload;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DownloadOptions;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.realization.inline.list.PlatformListRowInline;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import io.qameta.allure.Allure;

import java.io.File;
import java.util.function.Consumer;

import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static core.element.widget.AbstractWidget.logTime;

public class ListFileUpload<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		> extends FileUpload<W, ListFileUpload<W, RR, R>> implements ParentRow<R> {

	private final String identifier;

	private final R row;

	private final String REQUIRED_MESSAGE = "div[class=\"ant-tooltip-inner\"]";

	public ListFileUpload(W widget, R row, String title) {
		super(widget, title);
		this.identifier = title;
		this.row = row;
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
	public ListFileUpload<W, RR, R> setValue(File value) {
		return Allure.step("Uploading a file to the {value} field", step -> {
			logTime(step);
			step.parameter("File", value.getName());
			element().$(valueTag()).uploadFile(value);
			element()
					.$("button")
					.shouldHave(Condition.text(value.getName()), widget().getExpectations().getTimeout());
			return this;
		});
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public SelenideElement element() {
		return row.element().
				$$("div[data-test-field-type='" + fieldType().getType() + "'][data-test-field-title=\"" + identifier + "\"]")
				.get(0)
				.scrollIntoView("{block: \"center\"}")
				.shouldBe(Condition.enabled, widget().getExpectations().getTimeout());
	}

	public R row() {
		return row;
	}

	public FileUploadPopup<W, ListFileUpload<W, RR, R>> popup() {
		return new FileUploadPopup<>(widget().getExpectations(), this);
	}

	public ListFileUpload<W, RR, R> clear() {
		return Allure.step("Clearing the field. Deleting a file.", step -> {
			logTime(step);
			element();
			element().find("i[title=\"Delete\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();
			return this;
		});
	}

	public ListFileUpload<W, RR, R> checkFieldIsEmpty(Consumer<Boolean> fieldIsEmpty) {
		element();
		boolean isFieldIsEmpty = !element().$("button").shouldNot(Condition.exist, widget().getExpectations().getTimeout()).exists();
		fieldIsEmpty.accept(isFieldIsEmpty);
		return this;
	}

	@Override
	public ListFileUpload<W, RR, R> checkPlaceholder(Consumer<String> expectedPlaceholder) {
		element()
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$("span[title=\"Placeholder text\"]")
				.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
				.text();
		return this;
	}

	@Override
	public ListFileUpload<W, RR, R> checkReadOnly(Consumer<Boolean> expectedReadOnly) {
		expectedReadOnly.accept(element().$(".ant-upload-select.ant-upload-disabled").exists());
		return this;
	}


	@Override
	public ListFileUpload<W, RR, R> checkRequired(Consumer<String> checkRequired) {
		element()
				.hover()
				.$(REQUIRED_MESSAGE)
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.text();
		return this;
	}

	@Override
	public String valueTag() {
		if (row instanceof PlatformListRowInline ri && !ri.getIsEdit()) {
			return "button[class*='FileUpload__readOnlyFileButton']";
		}
		return super.valueTag();
	}
}
