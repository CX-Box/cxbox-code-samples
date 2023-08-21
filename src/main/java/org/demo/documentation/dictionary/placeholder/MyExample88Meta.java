package org.demo.documentation.dictionary.placeholder;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.dictionary.placeholder.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample88Meta extends FieldMetaBuilder<MyExample88DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample88DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample88DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample88DTO_.customField);
		fields.setPlaceholder(MyExample88DTO_.customField, "Placeholder text");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample88DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample88DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample88DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample88DTO_.customField);
	}

}