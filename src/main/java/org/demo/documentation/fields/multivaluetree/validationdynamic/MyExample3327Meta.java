package org.demo.documentation.fields.multivaluetree.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3327Meta extends FieldMetaBuilder<MyExample3327DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3327DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3327DTO_.customField);
		fields.setEnabled(MyExample3327DTO_.customFieldAdditional);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3327DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
	}
	// --8<-- [end:buildIndependentMeta]

}