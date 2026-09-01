package org.demo.documentation.widgets.tree.actions.edit.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3273Meta extends FieldMetaBuilder<MyExample3273DTO> {
	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3273DTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(MyExample3273DTO_.customFieldMoney);
		fields.setEnabled(MyExample3273DTO_.parentId);
		fields.setEnabled(MyExample3273DTO_.isLeaf);
		fields.setEnabled(MyExample3273DTO_.customFieldText);
		fields.setEnabled(MyExample3273DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3273DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3273DTO_.customFieldMoney);
		fields.enableFilter(MyExample3273DTO_.customFieldText);
		fields.enableFilter(MyExample3273DTO_.customField);
		fields.enableSort(MyExample3273DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}