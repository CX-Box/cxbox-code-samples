package org.demo.documentation.fields.radio.placeholder;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.radio.placeholder.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample26Meta extends FieldMetaBuilder<MyExample26DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample26DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample26DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample26DTO_.customField);
		fields.setPlaceholder(MyExample26DTO_.customField, CustomFieldEnum.MIDDLE.toString());
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample26DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample26DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample26DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample26DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}