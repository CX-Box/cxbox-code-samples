package core.element.widget.filepreview;

import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.list.filter.header.modal.FileViewer;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import io.qameta.allure.Allure;

/** FilePreview widget: the file of the current record is shown on the right half of the view. */
public class FilePreviewWidget extends PlatformWidget<FilePreviewWidget> {

	public FilePreviewWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.FILE_PREVIEW;
	}

	/** The file viewer of the widget, the same as in the popup of a file field. */
	public FileViewer viewer() {
		return Allure.step("Getting the file viewer of the widget", step -> {
			logTime(step);
			return new FileViewer(element());
		});
	}

}
