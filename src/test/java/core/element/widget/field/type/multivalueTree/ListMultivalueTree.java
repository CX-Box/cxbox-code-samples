package core.element.widget.field.type.multivalueTree;

import core.config.Constants;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.type.multivalue.ListMultivalue;
import core.element.widget.field.type.multivalue.MultivalueModal;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import io.qameta.allure.Allure;

import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListMultivalueTree<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		> extends ListMultivalue<W, RR, R> {

	public ListMultivalueTree(W widget, String identifier, R parent) {
		super(widget, identifier, parent);
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.MULTIVALUE_TREE_LIST;
	}

	@Override
	protected MultivalueModal<W> modal() {
		return new AssocTreeModal<>(widget());
	}

	/** The read-only cell of a multivalueTree lists the records in a colored span, not in the hover paragraph of multivalue. */
	@Override
	public ListMultivalue<W, RR, R> checkColor(Consumer<String> checkColor) {
		return Allure.step("Getting color for field", step -> {
			String style = element().$("span[style*=\"background-color\"], p[style*=\"background-color\"]").getAttribute("style");
			Matcher matcher = Pattern.compile("rgb\\((\\d{1,3}), (\\d{1,3}), (\\d{1,3})\\)").matcher(String.valueOf(style));
			if (matcher.find()) {
				checkColor.accept(String.format(Constants.FormatForRgb,
						Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))));
			}
			return this;
		});
	}

}
