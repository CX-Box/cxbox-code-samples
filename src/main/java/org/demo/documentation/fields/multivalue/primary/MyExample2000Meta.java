package org.demo.documentation.fields.multivalue.primary;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample2000Meta extends FieldMetaBuilder<MyExample2000DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample2000DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample2000DTO_.customField);
		fields.setEnabled(MyExample2000DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample2000DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyExample2000DTO_.customField);
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample2000DTO_.customField);
		}
		fields.enableFilter(MyExample2000DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}