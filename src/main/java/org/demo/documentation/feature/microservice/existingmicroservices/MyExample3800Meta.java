package org.demo.documentation.feature.microservice.existingmicroservices;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3800Meta extends AnySourceFieldMetaBuilder<MyExample3800DTO> {
	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3800DTO> fields, BcDescription bc,
									  String id, String parentId) {
		fields.setEnabled(MyExample3800DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3800DTO> fields, BcDescription bcDescription,
									 String parentId) {
		fields.enableFilter(MyExample3800DTO_.customField);
		fields.enableSort(MyExample3800DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}