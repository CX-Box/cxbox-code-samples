package org.demo.documentation.inlinepicklist.placeholder;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample144Meta extends FieldMetaBuilder<MyExample144DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample144DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample144DTO_.customFieldId);
		fields.setEnabled(MyExample144DTO_.customField);
		fields.setPlaceholder(MyExample144DTO_.customField, "placeholder text");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample144DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample144DTO_.customField);
		}
		fields.enableFilter(MyExample144DTO_.customField);
	}

}