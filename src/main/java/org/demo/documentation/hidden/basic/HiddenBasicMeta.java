package org.demo.documentation.hidden.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HiddenBasicMeta extends FieldMetaBuilder<HiddenBasicDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<HiddenBasicDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				HiddenBasicDTO_.customField
		);
		fields.setRequired(
				HiddenBasicDTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<HiddenBasicDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(HiddenBasicDTO_.customField);
		}
		//
	}


}