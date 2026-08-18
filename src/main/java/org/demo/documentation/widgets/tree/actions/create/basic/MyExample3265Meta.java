package org.demo.documentation.widgets.tree.actions.create.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3265Meta extends FieldMetaBuilder<MyExample3265DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3265DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3265DTO_.customFieldText);
		fields.setEnabled(MyExample3265DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3265DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3265DTO_.customFieldText);
		fields.enableSort(MyExample3265DTO_.customFieldText);
		fields.enableSort(MyExample3265DTO_.customField);
	}

}