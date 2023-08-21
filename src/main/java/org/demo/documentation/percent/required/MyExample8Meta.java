package org.demo.documentation.percent.required;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample8Meta extends FieldMetaBuilder<MyExample8DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample8DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample8DTO_.customField
		);
		fields.setRequired(
				MyExample8DTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample8DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		//
	}


}