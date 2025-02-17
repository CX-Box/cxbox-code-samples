package org.demo.documentation.fields.datetimewithseconds.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample322Meta extends FieldMetaBuilder<MyExample322DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample322DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample322DTO_.customFieldAdditional);
		fields.setEnabled(MyExample322DTO_.customField);
		fields.setPlaceholder(MyExample322DTO_.customField, "More than the current date");
		fields.setPlaceholder(MyExample322DTO_.customFieldAdditional, "More than the current date");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample322DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample322DTO_.customFieldAdditional);
		fields.enableFilter(MyExample322DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}