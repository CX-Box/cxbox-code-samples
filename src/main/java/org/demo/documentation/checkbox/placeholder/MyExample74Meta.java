package org.demo.documentation.checkbox.placeholder;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample74Meta extends FieldMetaBuilder<MyExample74DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample74DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample74DTO_.customField);
		fields.setPlaceholder(MyExample74DTO_.customField, Boolean.TRUE.toString());
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample74DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample74DTO_.customField);
		}
		fields.enableFilter(MyExample74DTO_.customField);
	}

}