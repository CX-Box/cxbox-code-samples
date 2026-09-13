package org.demo.documentation.widgets.picktree.fieldslayoute;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3346Meta extends FieldMetaBuilder<MyExample3346DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3346DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3346DTO_.customFieldId);
		fields.setEnabled(MyExample3346DTO_.customField);

	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3346DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3346DTO_.customField);
		fields.enableSort(MyExample3346DTO_.customField);
		fields.enableSort(MyExample3346DTO_.customFieldId);
	}

}