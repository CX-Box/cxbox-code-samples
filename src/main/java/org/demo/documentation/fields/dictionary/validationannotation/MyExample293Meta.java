package org.demo.documentation.fields.dictionary.validationannotation;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.dictionary.validationannotation.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample293Meta extends FieldMetaBuilder<MyExample293DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample293DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample293DTO_.customField);
		fields.setPlaceholder(MyExample293DTO_.customField, "Not null");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample293DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample293DTO_.customField);
		}
		fields.setEnumValues(MyExample293DTO_.customField, CustomFieldEnum.values());
		fields.setEnumFilterValues(fields, MyExample293DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample293DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}