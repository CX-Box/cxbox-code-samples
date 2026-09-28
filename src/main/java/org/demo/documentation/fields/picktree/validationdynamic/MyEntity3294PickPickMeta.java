package org.demo.documentation.fields.picktree.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3294PickPickMeta extends FieldMetaBuilder<MyEntity3294PickPickDTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3294PickPickDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.picktree.validationdynamic.MyEntity3294PickPickDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3294PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3294PickPickDTO_.customField);
		fields.enableSort(MyEntity3294PickPickDTO_.customField);
		fields.enableSort(MyEntity3294PickPickDTO_.id);
	}
	// --8<-- [end:buildIndependentMeta]

}
