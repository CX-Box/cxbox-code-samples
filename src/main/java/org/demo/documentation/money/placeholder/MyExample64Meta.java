package org.demo.documentation.money.placeholder;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample64Meta extends FieldMetaBuilder<MyExample64DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:documentation]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample64DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample64DTO_.customField);
		fields.setPlaceholder(MyExample64DTO_.customField, "100000.00");
	}
	// --8<-- [end:documentation]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample64DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample64DTO_.customField);
		}
		fields.enableFilter(MyExample64DTO_.customField);
	}

}