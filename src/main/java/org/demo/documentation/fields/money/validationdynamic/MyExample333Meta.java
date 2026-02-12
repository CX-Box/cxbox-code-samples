package org.demo.documentation.fields.money.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample333Meta extends FieldMetaBuilder<MyExample333DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample333DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample333DTO_.customField);
		fields.setEnabled(MyExample333DTO_.customFieldAdditional);
		fields.setPlaceholder(MyExample333DTO_.customField, "More than 100 000.00");
		fields.setPlaceholder(MyExample333DTO_.customFieldAdditional, "More than 100 000.00");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample333DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
	}

}