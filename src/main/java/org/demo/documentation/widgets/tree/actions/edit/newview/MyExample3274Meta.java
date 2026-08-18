package org.demo.documentation.widgets.tree.actions.edit.newview;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3274Meta extends FieldMetaBuilder<MyExample3274DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3274DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3274DTO_.customFieldText);
		fields.setEnabled(MyExample3274DTO_.customField);
		fields.setRequired(MyExample3274DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3274DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3274DTO_.customFieldText);
	}

}