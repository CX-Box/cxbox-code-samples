package org.demo.documentation.fields.money.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample56Meta extends FieldMetaBuilder<MyExample56DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:editable]
	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample56DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample56DTO_.customField);
	}
	// --8<-- [end:editable]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample56DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample56DTO_.customField);
		}
		fields.enableFilter(MyExample56DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}