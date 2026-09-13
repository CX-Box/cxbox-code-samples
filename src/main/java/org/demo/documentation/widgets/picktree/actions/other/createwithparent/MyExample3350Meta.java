package org.demo.documentation.widgets.picktree.actions.other.createwithparent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3350Meta extends FieldMetaBuilder<MyExample3350DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3350DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3350DTO_.customFieldRequred);
		fields.setEnabled(MyExample3350DTO_.customFieldText);
		fields.setEnabled(MyExample3350DTO_.customFieldId);
		fields.setEnabled(MyExample3350DTO_.customField);
		fields.setRequired(MyExample3350DTO_.customFieldRequred);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3350DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3350DTO_.customFieldRequred);
		fields.enableFilter(MyExample3350DTO_.customFieldText);
		fields.enableFilter(MyExample3350DTO_.customField);
		fields.enableSort(MyExample3350DTO_.customFieldRequred);
		fields.enableSort(MyExample3350DTO_.customFieldText);
		fields.enableSort(MyExample3350DTO_.customField);
		fields.enableSort(MyExample3350DTO_.id);
	}

}