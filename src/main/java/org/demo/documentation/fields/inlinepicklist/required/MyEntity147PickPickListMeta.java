package org.demo.documentation.fields.inlinepicklist.required;

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
public class MyEntity147PickPickListMeta extends FieldMetaBuilder<MyEntity147PickDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity147PickDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.inlinepicklist.required.MyEntity147PickDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.inlinepicklist.required.MyEntity147PickDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity147PickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableSort(MyEntity147PickDTO_.id);
		fields.enableSort(MyEntity147PickDTO_.customField);
//
	}

}
