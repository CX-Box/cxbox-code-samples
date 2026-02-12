package org.demo.documentation.other.savewithparent.example443.child;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3077Meta extends AnySourceFieldMetaBuilder<MyExample3077DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3077DTO> fields, BcDescription bcDescription,
									  String id, String parentId) {
		fields.setEnabled(MyExample3077DTO_.customField);
		fields.setRequired(MyExample3077DTO_.customField);
	}


	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3077DTO> fields, BcDescription bcDescription, String parentId) {
	}

}
