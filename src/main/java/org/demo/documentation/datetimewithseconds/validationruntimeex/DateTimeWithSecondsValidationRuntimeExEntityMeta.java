package org.demo.documentation.datetimewithseconds.validationruntimeex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateTimeWithSecondsValidationRuntimeExEntityMeta extends
		FieldMetaBuilder<DateTimeWithSecondsValidationRuntimeExEntityDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateTimeWithSecondsValidationRuntimeExEntityDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				DateTimeWithSecondsValidationRuntimeExEntityDTO_.customField
		);
		fields.setRequired(
				DateTimeWithSecondsValidationRuntimeExEntityDTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<DateTimeWithSecondsValidationRuntimeExEntityDTO> fields,
			InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateTimeWithSecondsValidationRuntimeExEntityDTO_.customField);
		}
		//
	}


}