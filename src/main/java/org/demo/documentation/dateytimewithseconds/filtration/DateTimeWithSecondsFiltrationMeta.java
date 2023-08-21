package org.demo.documentation.dateytimewithseconds.filtration;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateTimeWithSecondsFiltrationMeta extends FieldMetaBuilder<DateTimeWithSecondsFiltrationDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateTimeWithSecondsFiltrationDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				DateTimeWithSecondsFiltrationDTO_.customField
		);
		fields.setRequired(
				DateTimeWithSecondsFiltrationDTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<DateTimeWithSecondsFiltrationDTO> fields,
			InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateTimeWithSecondsFiltrationDTO_.customField);
		}
		fields.enableFilter(DateTimeWithSecondsFiltrationDTO_.customField);
	}

}