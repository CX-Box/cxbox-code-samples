package org.demo.documentation.radio.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.radio.basic.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample20Meta extends FieldMetaBuilder<MyExample20DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample20DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample20DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample20DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample20DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample20DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample20DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample20DTO_.customField);
	}

}