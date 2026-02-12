package org.demo.documentation.widgets.picklist.colortitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3060Meta extends FieldMetaBuilder<MyExample3060DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3060DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3060DTO_.customFieldPicklistColorConstId);
		fields.setEnabled(MyExample3060DTO_.customFieldPicklistColorConst);
		fields.setEnabled(MyExample3060DTO_.customFieldPicklistId);
		fields.setEnabled(MyExample3060DTO_.customFieldPicklist);

	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3060DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3060DTO_.customFieldPicklistColorConst);
		fields.enableFilter(MyExample3060DTO_.customFieldPicklist);
	}

}