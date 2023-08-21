package org.demo.documentation.datetime.sort;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateTimeSortMeta extends FieldMetaBuilder<DateTimeSortDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateTimeSortDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				DateTimeSortDTO_.customField
		);
		fields.setRequired(
				DateTimeSortDTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<DateTimeSortDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateTimeSortDTO_.customField);
		}
		//
	}


}