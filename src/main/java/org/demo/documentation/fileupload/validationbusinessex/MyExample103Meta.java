package org.demo.documentation.fileupload.validationbusinessex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample103Meta extends FieldMetaBuilder<MyExample103DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample103DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample103DTO_.customFieldId);
		fields.setEnabled(MyExample103DTO_.customField);
		fields.setPlaceholder(MyExample103DTO_.customField, "Only letters");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample103DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample103DTO_.customField);
		}
		fields.enableFilter(MyExample103DTO_.customField);
	}

}