package org.demo.documentation.dictionary.color;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.dictionary.color.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample71Meta extends FieldMetaBuilder<MyExample71DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample71DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample71DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample71DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample71DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample71DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample71DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample71DTO_.customField);
	}

}