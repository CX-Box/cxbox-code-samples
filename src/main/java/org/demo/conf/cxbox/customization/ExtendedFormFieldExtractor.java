package org.demo.conf.cxbox.customization;

import org.cxbox.core.util.JsonUtils;
import org.cxbox.meta.data.WidgetDTO;
import org.cxbox.meta.ui.field.link.LinkFieldExtractor;
import org.cxbox.meta.ui.model.BcField;
import org.cxbox.meta.ui.model.json.field.FieldGroup;
import org.cxbox.meta.ui.model.json.field.FieldMeta;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.cxbox.api.util.i18n.LocalizationFormatter.i18n;

public class ExtendedFormFieldExtractor extends CodeSamplesBaseFieldExtractor {

	public ExtendedFormFieldExtractor(LinkFieldExtractor linkFieldExtractor) {
		super(linkFieldExtractor);
	}

	@Override
	public Set<BcField> extract(WidgetDTO widget) {
		final Set<BcField> widgetFields = new HashSet<>(extractFieldsFromTitle(widget, i18n(widget.getTitle())));
		for (final FieldGroup group : JsonUtils.readValue(FieldGroup[].class, widget.getFields())) {
			if (group.getChildren() != null) {
				for (final FieldMeta field : group.getChildren()) {
					widgetFields.addAll(extract(widget, field));
				}
			}
		}
		return widgetFields;
	}

	@Override
	public List<String> getSupportedTypes() {
		return List.of(
				"Form"
		);
	}

}
