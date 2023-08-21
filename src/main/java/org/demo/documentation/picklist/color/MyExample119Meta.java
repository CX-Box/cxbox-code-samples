package org.demo.documentation.picklist.color;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample119Meta extends FieldMetaBuilder<MyExample119DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample119DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample119DTO_.customFieldId);
		fields.setEnabled(MyExample119DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample119DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample119DTO_.customField);
		}
		fields.enableFilter(MyExample119DTO_.customField);
	}

}