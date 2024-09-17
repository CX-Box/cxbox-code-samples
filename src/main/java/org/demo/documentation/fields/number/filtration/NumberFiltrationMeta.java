package org.demo.documentation.fields.number.filtration;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberFiltrationMeta extends FieldMetaBuilder<NumberFiltrationDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<NumberFiltrationDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				NumberFiltrationDTO_.customField
		);
		fields.setRequired(
				NumberFiltrationDTO_.customField
		);

	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<NumberFiltrationDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(NumberFiltrationDTO_.customField);
		}
		fields.enableFilter(NumberFiltrationDTO_.customField);
		fields.enableSort(NumberFiltrationDTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}