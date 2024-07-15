package org.demo.documentation.fields.radio.validationannotation;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.radio.validationannotation.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample294Meta extends FieldMetaBuilder<MyExample294DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample294DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample294DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample294DTO_.customField);
		fields.setPlaceholder(MyExample294DTO_.customField,"Not null");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample294DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample294DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample294DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample294DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}