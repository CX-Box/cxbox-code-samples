package core.element.widget.list;

import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.action.Action;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import io.qameta.allure.Allure;
import java.io.File;
import org.testcontainers.shaded.com.google.errorprone.annotations.CanIgnoreReturnValue;

public abstract class ListWidget<SELF extends ListWidget<SELF, ROWS, ROW>, ROWS extends PlatformRows<ROWS, SELF, ROW>, ROW extends PlatformRow<ROW, ROWS, SELF>> extends PlatformWidget<SELF> {

	public ListWidget(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	public abstract ROWS rows();

	public ListHeaders<SELF, ROWS, ROW> headers() {
		return new ListHeaders<>(self());
	}

	public ListPagination<SELF> pagination() {
		return new ListPagination<>(self());
	}

	@SuppressWarnings("unchecked")
	public SELF self() {
		return (SELF) this;
	}

	public Action<SELF> actions() {
		return new Action<>(self());
	}

	@CanIgnoreReturnValue
	public SELF uploadFilesViaDragAndDrop(File... files) {
		return Allure.step("Uploading multiple files via Drag & Drop zone", step -> {
			logTime(step);
			element().$(".ant-upload-drag input[type='file']").uploadFile(files);
			return self();
		});
	}

	@CanIgnoreReturnValue
	public SELF uploadFilesViaDragAndDropFromClasspath(String... fileNames) {
		return Allure.step("Uploading multiple files via Drag & Drop zone from classpath", step -> {
			logTime(step);
			element().$(".ant-upload-drag input[type='file']").uploadFromClasspath(fileNames);
			return self();
		});
	}

	@CanIgnoreReturnValue
	public SELF uploadFilesViaButton(File... files) {
		return Allure.step("Uploading multiple files via action button", step -> {
			logTime(step);
			element().$(".ant-upload-select input[type='file']").uploadFile(files);
			return self();
		});
	}

	@CanIgnoreReturnValue
	public SELF uploadFilesViaButtonFromClasspath(String... fileNames) {
		return Allure.step("Uploading multiple files via action button from classpath", step -> {
			logTime(step);
			element().$(".ant-upload-select input[type='file']").uploadFromClasspath(fileNames);
			return self();
		});
	}
}