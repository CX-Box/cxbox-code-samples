package org.demo.documentation.widgets.picktree.title.withtitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3344Meta extends FieldMetaBuilder<MyExample3344DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3344DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3344DTO_.customFieldId);
		fields.setEnabled(MyExample3344DTO_.customField);
		fields.setEnabled(MyExample3344DTO_.customFieldId);
		fields.setEnabled(MyExample3344DTO_.customField);

	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3344DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3344DTO_.customField);
		fields.enableSort(MyExample3344DTO_.customField);
		fields.enableSort(MyExample3344DTO_.customFieldId);
	}

}