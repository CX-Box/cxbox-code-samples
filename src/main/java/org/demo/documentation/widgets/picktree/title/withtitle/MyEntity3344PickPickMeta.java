package org.demo.documentation.widgets.picktree.title.withtitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3344PickPickMeta extends FieldMetaBuilder<MyEntity3344PickPickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3344PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3344PickPickDTO_.customFieldPick);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3344PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3344PickPickDTO_.parentId);
		fields.enableSort(MyEntity3344PickPickDTO_.id);
		fields.enableSort(MyEntity3344PickPickDTO_.customFieldPick);

	}

}
