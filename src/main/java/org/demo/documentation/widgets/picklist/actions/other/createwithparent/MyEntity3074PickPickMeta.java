package org.demo.documentation.widgets.picklist.actions.other.createwithparent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3074PickPickMeta extends FieldMetaBuilder<MyEntity3074PickPickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3074PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3074PickPickDTO_.id);
		fields.setEnabled(MyEntity3074PickPickDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3074PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableSort(MyEntity3074PickPickDTO_.id);
		fields.enableSort(MyEntity3074PickPickDTO_.customField);

	}

}
