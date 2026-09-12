package org.demo.documentation.fields.picktree.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3294Meta extends FieldMetaBuilder<MyExample3294DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3294DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3294DTO_.customFieldId);
		fields.setEnabled(MyExample3294DTO_.customField);
		fields.setEnabled(MyExample3294DTO_.customFieldAdditional);
		fields.setPlaceholder(MyExample3294DTO_.customField, "Only letters");
		fields.setPlaceholder(MyExample3294DTO_.customFieldAdditional, "Only letters");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3294DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyExample3294DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}