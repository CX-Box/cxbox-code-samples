package org.demo.documentation.checkbox.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MyExample82Meta extends FieldMetaBuilder<MyExample82DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample82DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample82DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample82DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample82DTO_.customField);
		}
		fields.enableFilter(MyExample82DTO_.customField);
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample82DTO_.customField);
		}
	}

}