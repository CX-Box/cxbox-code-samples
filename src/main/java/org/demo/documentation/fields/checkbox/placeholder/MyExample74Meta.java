package org.demo.documentation.fields.checkbox.placeholder;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.checkbox.placeholder.MyExample74DTO_;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample74Meta extends FieldMetaBuilder<MyExample74DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample74DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample74DTO_.customField);
		fields.setPlaceholder(MyExample74DTO_.customField, Boolean.TRUE.toString());
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample74DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample74DTO_.customField);
		}
		fields.enableFilter(MyExample74DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}