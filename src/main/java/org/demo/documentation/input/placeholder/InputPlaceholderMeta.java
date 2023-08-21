package org.demo.documentation.input.placeholder;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InputPlaceholderMeta extends FieldMetaBuilder<InputPlaceholderDTO> {

	private final DocumentConfig configuration;


	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<InputPlaceholderDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				InputPlaceholderDTO_.customField
		);
		fields.setPlaceholder(InputPlaceholderDTO_.customField, "placeholder text");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<InputPlaceholderDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(InputPlaceholderDTO_.customField);
		}
		//
	}

}
