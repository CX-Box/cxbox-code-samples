package org.demo.documentation.fields.checkbox.validationannotation;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.checkbox.validationdynamic.MyExample289DTO_;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample168Meta extends FieldMetaBuilder<MyExample168DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample168DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample168DTO_.customField);
		fields.setPlaceholder(MyExample168DTO_.customField,"Only 'True'");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample168DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample168DTO_.customField);
		}
		fields.enableFilter(MyExample168DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}