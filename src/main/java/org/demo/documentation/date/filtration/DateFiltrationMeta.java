package org.demo.documentation.date.filtration;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateFiltrationMeta extends FieldMetaBuilder<DateFiltrationDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateFiltrationDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				DateFiltrationDTO_.customField
		);
		fields.setRequired(
				DateFiltrationDTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<DateFiltrationDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateFiltrationDTO_.customField);
		}
		fields.enableFilter(DateFiltrationDTO_.customField);
	}

}