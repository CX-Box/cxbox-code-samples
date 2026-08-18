package org.demo.documentation.widgets.tree.actions.create.withwidget;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3279Meta extends FieldMetaBuilder<MyExample3279DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3279DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3279DTO_.customFieldText);
		fields.setEnabled(MyExample3279DTO_.customField);
		fields.setRequired(MyExample3279DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3279DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3279DTO_.customFieldText);
		fields.enableSort(MyExample3279DTO_.customFieldText);
		fields.enableSort(MyExample3279DTO_.customField);
	}

}