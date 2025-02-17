package org.demo.documentation.fields.text.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample332Meta extends FieldMetaBuilder<MyExample332DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample332DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample332DTO_.customFieldAdditional);
		fields.setEnabled(MyExample332DTO_.customField);
		fields.setPlaceholder(MyExample332DTO_.customField,"Only letters");
		fields.setPlaceholder(MyExample332DTO_.customFieldAdditional,"Only letters");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample332DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample332DTO_.customFieldAdditional);
		fields.enableFilter(MyExample332DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}