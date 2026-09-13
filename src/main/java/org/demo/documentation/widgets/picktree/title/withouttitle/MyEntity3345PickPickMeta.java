package org.demo.documentation.widgets.picktree.title.withouttitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3345PickPickMeta extends FieldMetaBuilder<MyEntity3345PickPickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3345PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.picktree.title.withouttitle.MyEntity3345PickPickDTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.picktree.title.withouttitle.MyEntity3345PickPickDTO_.customFieldPick);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3345PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3345PickPickDTO_.parentId);
		fields.enableSort(MyEntity3345PickPickDTO_.id);
		fields.enableSort(MyEntity3345PickPickDTO_.customFieldPick);

	}

}
