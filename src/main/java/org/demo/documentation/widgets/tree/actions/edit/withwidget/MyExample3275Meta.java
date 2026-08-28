package org.demo.documentation.widgets.tree.actions.edit.withwidget;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3275Meta extends FieldMetaBuilder<MyExample3275DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3275DTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(MyExample3275DTO_.customFieldMoney);
		fields.setEnabled(MyExample3275DTO_.parentId);
		fields.setEnabled(MyExample3275DTO_.isLeaf);
		fields.setEnabled(MyExample3275DTO_.customFieldText);
		fields.setEnabled(MyExample3275DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3275DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3275DTO_.customFieldMoney);
		fields.enableFilter(MyExample3275DTO_.customFieldText);
	}

}