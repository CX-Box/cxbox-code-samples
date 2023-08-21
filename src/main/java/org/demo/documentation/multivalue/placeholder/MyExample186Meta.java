package org.demo.documentation.multivalue.placeholder;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample186Meta extends FieldMetaBuilder<MyExample186DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample186DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample186DTO_.customField);
		fields.setPlaceholder(MyExample186DTO_.customField, "Placeholder text");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample186DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample186DTO_.customField);
		}
		fields.enableFilter(MyExample186DTO_.customField);
	}

}