package org.demo.documentation.fields.inlinepicklist.validationconfirm;

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
public class MyEntity153PickPickListMeta extends FieldMetaBuilder<MyEntity153PickDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity153PickDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.inlinepicklist.validationconfirm.MyEntity153PickDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.inlinepicklist.validationconfirm.MyEntity153PickDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity153PickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableSort(MyEntity153PickDTO_.id);
		fields.enableSort(MyEntity153PickDTO_.customField);

	}

}
