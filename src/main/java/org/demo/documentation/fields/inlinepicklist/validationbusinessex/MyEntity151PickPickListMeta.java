package org.demo.documentation.fields.inlinepicklist.validationbusinessex;

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
public class MyEntity151PickPickListMeta extends FieldMetaBuilder<MyEntity151PickDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity151PickDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.inlinepicklist.validationbusinessex.MyEntity151PickDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.inlinepicklist.validationbusinessex.MyEntity151PickDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity151PickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableSort(MyEntity151PickDTO_.id);
		fields.enableSort(MyEntity151PickDTO_.customField);

//
	}

}
