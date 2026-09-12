package org.demo.documentation.widgets.picktree.actions.other.createcustomsave;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3349Meta extends FieldMetaBuilder<MyExample3349DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3349DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3349DTO_.customFieldRequred);
		fields.setEnabled(MyExample3349DTO_.customFieldId);
		fields.setEnabled(MyExample3349DTO_.customField);

	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3349DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3349DTO_.customFieldRequred);
		fields.enableFilter(MyExample3349DTO_.customField);
		fields.enableSort(MyExample3349DTO_.customField);
		fields.enableSort(MyExample3349DTO_.customFieldRequred);
		fields.enableSort(MyExample3349DTO_.customFieldId);

	}

}