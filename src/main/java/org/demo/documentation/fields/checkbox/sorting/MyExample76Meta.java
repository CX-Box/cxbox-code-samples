package org.demo.documentation.fields.checkbox.sorting;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample76Meta extends FieldMetaBuilder<MyExample76DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample76DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {

		fields.setEnabled(MyExample76DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample76DTO> fields, InnerBcDescription bcDescription, Long parentId) {

		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample76DTO_.customField);
		}
		fields.enableFilter(MyExample76DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}