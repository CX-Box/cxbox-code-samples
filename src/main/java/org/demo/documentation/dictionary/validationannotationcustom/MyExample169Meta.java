package org.demo.documentation.dictionary.validationannotationcustom;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;

import org.demo.documentation.dictionary.validationannotationcustom.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample169Meta extends FieldMetaBuilder<MyExample169DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample169DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample169DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample169DTO_.customField);
		fields.setPlaceholder(MyExample169DTO_.customField,"any of 'High,Middle'");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample169DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample169DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample169DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample169DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}