package org.demo.documentation.percent.validationbusinessex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample10Meta extends FieldMetaBuilder<MyExample10DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample10DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample10DTO_.customField
		);
		fields.setRequired(
				MyExample10DTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample10DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		//
	}


}