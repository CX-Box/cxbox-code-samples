package org.demo.documentation.getstarted.microservice.document;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4003Meta extends AnySourceFieldMetaBuilder<MyExample4003DTO> {
	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4003DTO> fields, BcDescription bc,
									  String id, String parentId) {
	}

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4003DTO> fields, BcDescription bcDescription,
									 String parentId) {
	}

}