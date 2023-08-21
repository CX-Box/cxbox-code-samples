package org.demo.documentation.input.ro;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InputCreateEditMeta extends FieldMetaBuilder<InputCreateEditDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<InputCreateEditDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<InputCreateEditDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(InputCreateEditDTO_.customField);
		}
	}

}
