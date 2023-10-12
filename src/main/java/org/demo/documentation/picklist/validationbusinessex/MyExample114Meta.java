package org.demo.documentation.picklist.validationbusinessex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample114Meta extends FieldMetaBuilder<MyExample114DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample114DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample114DTO_.customFieldId);
		fields.setEnabled(MyExample114DTO_.customField);
		fields.setPlaceholder(MyExample114DTO_.customField,"Only letters");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample114DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample114DTO_.customField);
		}
		fields.enableFilter(MyExample114DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}