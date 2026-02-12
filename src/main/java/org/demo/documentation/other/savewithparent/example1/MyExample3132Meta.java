package org.demo.documentation.other.savewithparent.example1;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3132Meta extends FieldMetaBuilder<MyExample3132DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3132DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3132DTO_.customFieldInfo);
		fields.setEnabled(MyExample3132DTO_.customField3);
		fields.setEnabled(MyExample3132DTO_.customField2);
		fields.setEnabled(MyExample3132DTO_.customField);
		fields.setRequired(MyExample3132DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3132DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3132DTO_.customFieldInfo);
		fields.enableFilter(MyExample3132DTO_.customField3);
		fields.enableFilter(MyExample3132DTO_.customField2);
	}

}