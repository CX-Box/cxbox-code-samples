package org.demo.documentation.widgets.picklist.title.calculatedtitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3071Meta extends FieldMetaBuilder<MyExample3071DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3071DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3071DTO_.customFieldId);
		fields.setEnabled(MyExample3071DTO_.customField);

	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3071DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableSort(MyExample3071DTO_.customFieldId);
		fields.enableSort(MyExample3071DTO_.customField);
		fields.enableFilter(MyExample3071DTO_.customField);
	}

}