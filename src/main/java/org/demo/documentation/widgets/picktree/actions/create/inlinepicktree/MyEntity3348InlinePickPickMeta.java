package org.demo.documentation.widgets.picktree.actions.create.inlinepicktree;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3348InlinePickPickMeta extends FieldMetaBuilder<MyEntity3348InlinePickPickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3348InlinePickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3348InlinePickPickDTO_.customFieldPick);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3348InlinePickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3348InlinePickPickDTO_.parentId);

		fields.enableSort(MyEntity3348InlinePickPickDTO_.id);
		fields.enableSort(MyEntity3348InlinePickPickDTO_.customFieldPick);

	}
	// --8<-- [end:buildIndependentMeta]
}
