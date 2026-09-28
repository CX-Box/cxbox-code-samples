package org.demo.documentation.widgets.picktree.title.calculatedtitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3347PickPickMeta extends FieldMetaBuilder<MyEntity3347PickPickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3347PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3347PickPickDTO_.customFieldPick);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3347PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3347PickPickDTO_.parentId);

		fields.enableSort(org.demo.documentation.widgets.picktree.title.calculatedtitle.MyEntity3347PickPickDTO_.id);
		fields.enableSort(org.demo.documentation.widgets.picktree.title.calculatedtitle.MyEntity3347PickPickDTO_.customFieldPick);

	}

}
