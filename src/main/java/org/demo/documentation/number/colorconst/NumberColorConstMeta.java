package org.demo.documentation.number.colorconst;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberColorConstMeta extends FieldMetaBuilder<NumberColorConstDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<NumberColorConstDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				NumberColorConstDTO_.customField
		);
		fields.setRequired(
				NumberColorConstDTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<NumberColorConstDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(NumberColorConstDTO_.customField);
		}
		//
	}


}