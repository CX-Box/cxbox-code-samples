package org.demo.documentation.fields.picklist.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity401PickPickMeta extends FieldMetaBuilder<MyEntity401PickPickDTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity401PickPickDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.picklist.validationdynamic.MyEntity401PickPickDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.picklist.validationdynamic.MyEntity401PickPickDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity401PickPickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyEntity401PickPickDTO_.customField);
		fields.enableSort(MyEntity401PickPickDTO_.customField);
		fields.enableSort(MyEntity401PickPickDTO_.id);
	}

}
