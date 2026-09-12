package org.demo.documentation.widgets.assoctree.colortitle.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3329Meta extends FieldMetaBuilder<MyExample3329DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3329DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3329DTO_.customFieldMulti);
		fields.setEnabled(MyExample3329DTO_.customField);
		fields.setRequired(MyExample3329DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3329DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3329DTO_.customFieldMulti);
	}

}