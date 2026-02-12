package org.demo.documentation.widgets.property.pagination.nextandprevioussmart;


import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3861Meta extends AnySourceFieldMetaBuilder<MyExample3861DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3861DTO> fields, BcDescription bcDescription, String id, String parentId) {
		fields.setEnabled(MyExample3861DTO_.customField);
		fields.setRequired(MyExample3861DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3861DTO> fields, BcDescription bcDescription, String parentId) {
		fields.enableSort(MyExample3861DTO_.customField);

	}
}