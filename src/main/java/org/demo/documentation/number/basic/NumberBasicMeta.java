package org.demo.documentation.number.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberBasicMeta extends FieldMetaBuilder<NumberBasicDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<NumberBasicDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				NumberBasicDTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<NumberBasicDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		//
	}


}