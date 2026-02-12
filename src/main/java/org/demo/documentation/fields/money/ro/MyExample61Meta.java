package org.demo.documentation.fields.money.ro;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample61Meta extends FieldMetaBuilder<MyExample61DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:ro]
	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample61DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {

	}
	// --8<-- [end:ro]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample61DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample61DTO_.customField);
		}
		fields.enableFilter(MyExample61DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}