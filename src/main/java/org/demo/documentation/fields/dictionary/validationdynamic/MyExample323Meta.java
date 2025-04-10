package org.demo.documentation.fields.dictionary.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample323Meta extends FieldMetaBuilder<MyExample323DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample323DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample323DTO_.customField);
		fields.setEnabled(MyExample323DTO_.customFieldAdditional);
		fields.setPlaceholder(MyExample323DTO_.customField,"Only HIGH");
		fields.setPlaceholder(MyExample323DTO_.customFieldAdditional,"Only HIGH");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample323DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.setEnumValues(MyExample323DTO_.customFieldAdditional);
	}

}