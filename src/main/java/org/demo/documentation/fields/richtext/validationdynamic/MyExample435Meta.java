package org.demo.documentation.fields.richtext.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample435Meta extends FieldMetaBuilder<MyExample435DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample435DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample435DTO_.customFieldAdditional);
		fields.setEnabled(MyExample435DTO_.customField);
		fields.setPlaceholder(MyExample435DTO_.customField, "No more than 50 characters");
		fields.setPlaceholder(MyExample435DTO_.customFieldAdditional, "No more than 50 characters");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample435DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyExample435DTO_.customFieldAdditional);
		fields.enableFilter(MyExample435DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}