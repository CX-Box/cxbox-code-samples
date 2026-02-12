package org.demo.documentation.fields.radio.validationbusinessex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.radio.validationbusinessex.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample29Meta extends FieldMetaBuilder<MyExample29DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample29DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample29DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample29DTO_.customField);
		fields.setPlaceholder(MyExample29DTO_.customField, "Only 'High'");

	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample29DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample29DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample29DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample29DTO_.customField);
		//
	}


}