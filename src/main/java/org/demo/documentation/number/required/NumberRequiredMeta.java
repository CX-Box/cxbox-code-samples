package org.demo.documentation.number.required;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberRequiredMeta extends FieldMetaBuilder<NumberRequiredDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<NumberRequiredDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				NumberRequiredDTO_.customField
		);
		fields.setRequired(
				NumberRequiredDTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<NumberRequiredDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(NumberRequiredDTO_.customField);
		}
		//
	}


}