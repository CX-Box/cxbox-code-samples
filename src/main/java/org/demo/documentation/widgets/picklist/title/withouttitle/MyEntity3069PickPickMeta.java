package org.demo.documentation.widgets.picklist.title.withouttitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3069PickPickMeta extends FieldMetaBuilder<MyEntity3069PickPickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3069PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.picklist.title.withouttitle.MyEntity3069PickPickDTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.picklist.title.withouttitle.MyEntity3069PickPickDTO_.customFieldPick);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3069PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableSort(MyEntity3069PickPickDTO_.id);
		fields.enableSort(MyEntity3069PickPickDTO_.customFieldPick);

	}

}
