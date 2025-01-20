package org.demo.documentation.fields.date.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample320Meta extends FieldMetaBuilder<MyExample320DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample320DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample320DTO_.customFieldAdditional);
		fields.setEnabled(MyExample320DTO_.customField);
		fields.setPlaceholder(MyExample320DTO_.customField, "More than the current date");
		fields.setPlaceholder(MyExample320DTO_.customFieldAdditional, "More than the current date");

	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample320DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample320DTO_.customFieldAdditional);
		fields.enableFilter(MyExample320DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}