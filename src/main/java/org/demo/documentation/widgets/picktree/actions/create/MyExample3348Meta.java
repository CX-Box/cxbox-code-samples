package org.demo.documentation.widgets.picktree.actions.create;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3348Meta extends FieldMetaBuilder<MyExample3348DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3348DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3348DTO_.customFieldInlinePicktreeId);
		fields.setEnabled(MyExample3348DTO_.customFieldInlinePicktree);
		fields.setEnabled(MyExample3348DTO_.customFieldId);
		fields.setEnabled(MyExample3348DTO_.customField);

	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3348DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3348DTO_.customFieldInlinePicktree);
		fields.enableFilter(MyExample3348DTO_.customField);
		fields.enableSort(MyExample3348DTO_.customFieldInlinePicktree);
		fields.enableSort(MyExample3348DTO_.customField);
	}

}