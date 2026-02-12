package org.demo.documentation.fields.picklist.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample400Meta extends FieldMetaBuilder<MyExample400DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample400DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample400DTO_.customFieldId);
		fields.setEnabled(MyExample400DTO_.customField);
		fields.setEnabled(MyExample400DTO_.customFieldAdditional);
		fields.setPlaceholder(MyExample400DTO_.customField, "Only letters");
		fields.setPlaceholder(MyExample400DTO_.customFieldAdditional, "Only letters");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample400DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyExample400DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}