package org.demo.documentation.fields.input.filtration;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InputFiltrationMeta extends FieldMetaBuilder<InputFiltrationDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<InputFiltrationDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(InputFiltrationDTO_.brand);
		fields.setEnabled(
				InputFiltrationDTO_.customField
		);
		fields.setRequired(
				InputFiltrationDTO_.customField
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<InputFiltrationDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(InputFiltrationDTO_.customField);
		}
		fields.enableFilter(InputFiltrationDTO_.brand);
		fields.enableFilter(InputFiltrationDTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}