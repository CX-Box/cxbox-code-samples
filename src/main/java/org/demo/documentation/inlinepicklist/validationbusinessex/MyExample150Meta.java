package org.demo.documentation.inlinepicklist.validationbusinessex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample150Meta extends FieldMetaBuilder<MyExample150DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample150DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample150DTO_.customFieldId);
		fields.setEnabled(MyExample150DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample150DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample150DTO_.customField);
		}
		fields.enableFilter(MyExample150DTO_.customField);
	}

}