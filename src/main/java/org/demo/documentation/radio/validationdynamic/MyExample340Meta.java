package org.demo.documentation.radio.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.demo.documentation.radio.validationdynamic.enums.CustomFieldAdditionalEnum;
import org.demo.documentation.radio.validationdynamic.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample340Meta extends FieldMetaBuilder<MyExample340DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample340DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample340DTO_.customFieldAdditional, CustomFieldAdditionalEnum.values());
		fields.setEnabled(MyExample340DTO_.customFieldAdditional);
		fields.setEnumValues(MyExample340DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample340DTO_.customField);
		fields.setPlaceholder(MyExample340DTO_.customField,"Only 'High'");
		fields.setPlaceholder(MyExample340DTO_.customFieldAdditional,"Only 'High'");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample340DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.setEnumFilterValues(fields, MyExample340DTO_.customFieldAdditional, CustomFieldAdditionalEnum.values());
		fields.enableFilter(MyExample340DTO_.customFieldAdditional);
		fields.setEnumFilterValues(fields, MyExample340DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample340DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}