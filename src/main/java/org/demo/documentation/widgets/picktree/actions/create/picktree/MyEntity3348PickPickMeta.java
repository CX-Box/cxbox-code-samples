package org.demo.documentation.widgets.picktree.actions.create.picktree;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3348PickPickMeta extends FieldMetaBuilder<MyEntity3348PickPickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3348PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3348PickPickDTO_.id);
		fields.setEnabled(MyEntity3348PickPickDTO_.customFieldPick);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3348PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3348PickPickDTO_.parentId);
		fields.enableSort(MyEntity3348PickPickDTO_.id);
		fields.enableSort(MyEntity3348PickPickDTO_.customFieldPick);

	}
	// --8<-- [end:buildIndependentMeta]
}
