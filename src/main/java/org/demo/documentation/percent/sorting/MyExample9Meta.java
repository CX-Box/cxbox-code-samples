package org.demo.documentation.percent.sorting;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample9Meta extends FieldMetaBuilder<MyExample9DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample9DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample9DTO_.customField
		);
		fields.setRequired(
				MyExample9DTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample9DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		//
	}


}