package org.demo.documentation.widgets.assoc.colortitle.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3052Meta extends FieldMetaBuilder<MyExample3052DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3052DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3052DTO_.customFieldMulti);
		fields.setEnabled(MyExample3052DTO_.customField);
		fields.setRequired(MyExample3052DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3052DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3052DTO_.customFieldMulti);
	}

}