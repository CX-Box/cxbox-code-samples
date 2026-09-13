package org.demo.documentation.widgets.assoctree.actions.other.customsave;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3334Meta extends FieldMetaBuilder<MyExample3334DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3334DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3334DTO_.customFieldRequired);
		fields.setEnabled(MyExample3334DTO_.customField);
		fields.setRequired(MyExample3334DTO_.customFieldRequired);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3334DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3334DTO_.customFieldRequired);
		fields.enableFilter(MyExample3334DTO_.customField);
		fields.enableSort(MyExample3334DTO_.customFieldRequired);
		fields.enableSort(MyExample3334DTO_.customField);
		fields.enableSort(MyExample3334DTO_.customFieldDisplayedKey);
	}

}