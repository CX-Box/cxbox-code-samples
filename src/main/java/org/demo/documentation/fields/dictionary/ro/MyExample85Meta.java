package org.demo.documentation.fields.dictionary.ro;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.dictionary.ro.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample85Meta extends FieldMetaBuilder<MyExample85DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample85DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {

	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample85DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample85DTO_.customField);
		}
		fields.setEnumValues(MyExample85DTO_.customField, CustomFieldEnum.values());
		fields.setEnumFilterValues(fields, MyExample85DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample85DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}