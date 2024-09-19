package org.demo.documentation.fields.picklist.validationruntimeex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@RequiredArgsConstructor
@Service
public class MyEntity131PickPickListMeta extends FieldMetaBuilder<MyEntity131PickDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity131PickDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.picklist.validationruntimeex.MyEntity131PickDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.picklist.validationruntimeex.MyEntity131PickDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity131PickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyEntity131PickDTO_.customField);
		fields.enableSort(MyEntity131PickDTO_.customField);
		fields.enableSort(MyEntity131PickDTO_.id);
	}
	// --8<-- [end:buildIndependentMeta]
}
