package org.demo.documentation.fields.input.validationruntimeex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InputValidationRuntimeExceptionMeta extends FieldMetaBuilder<InputValidationRuntimeExceptionDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<InputValidationRuntimeExceptionDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(
				InputValidationRuntimeExceptionDTO_.customField
		);
		fields.setRequired(
				InputValidationRuntimeExceptionDTO_.customField
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<InputValidationRuntimeExceptionDTO> fields,
									 InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(InputValidationRuntimeExceptionDTO_.customField);
		}
	}
	// --8<-- [end:buildIndependentMeta]


}