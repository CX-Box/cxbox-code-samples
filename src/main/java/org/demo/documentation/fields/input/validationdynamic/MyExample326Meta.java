package org.demo.documentation.fields.input.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample326Meta extends FieldMetaBuilder<MyExample326DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample326DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample326DTO_.customFieldAdditional);
		fields.setEnabled(MyExample326DTO_.customField);
		fields.setPlaceholder(MyExample326DTO_.customFieldAdditional, "Only letters");
		fields.setPlaceholder(MyExample326DTO_.customField, "Only letters");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample326DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample326DTO_.customFieldAdditional);
		fields.enableFilter(MyExample326DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}