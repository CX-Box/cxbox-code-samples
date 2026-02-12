package org.demo.documentation.widgets.picklist.actions.create.inlinepicklist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3072InlinePickPickMeta extends FieldMetaBuilder<MyEntity3072InlinePickPickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3072InlinePickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3072InlinePickPickDTO_.id);
		fields.setEnabled(MyEntity3072InlinePickPickDTO_.customFieldPick);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3072InlinePickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

		fields.enableSort(MyEntity3072InlinePickPickDTO_.id);
		fields.enableSort(MyEntity3072InlinePickPickDTO_.customFieldPick);

	}
	// --8<-- [end:buildIndependentMeta]
}
