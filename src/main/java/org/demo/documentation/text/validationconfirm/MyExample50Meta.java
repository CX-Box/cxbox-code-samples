package org.demo.documentation.text.validationconfirm;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample50Meta extends FieldMetaBuilder<MyExample50DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample50DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample50DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample50DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample50DTO_.customField);
		}
		fields.enableFilter(MyExample50DTO_.customField);
		//
	}


}