package org.demo.documentation.widgets.tree.actions.create.newview;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3266Meta extends FieldMetaBuilder<MyExample3266DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3266DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3266DTO_.customFieldText);
		fields.setEnabled(MyExample3266DTO_.customField);
		fields.setRequired(MyExample3266DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3266DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3266DTO_.customFieldText);
		fields.enableSort(MyExample3266DTO_.customFieldText);
		fields.enableSort(MyExample3266DTO_.customField);
	}

}