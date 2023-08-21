package org.demo.documentation.number.validationconfirm;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberConfirmMeta extends FieldMetaBuilder<NumberConfirmDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<NumberConfirmDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				NumberConfirmDTO_.customField
		);
		fields.setRequired(
				NumberConfirmDTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<NumberConfirmDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(NumberConfirmDTO_.customField);
		}
		//
	}


}