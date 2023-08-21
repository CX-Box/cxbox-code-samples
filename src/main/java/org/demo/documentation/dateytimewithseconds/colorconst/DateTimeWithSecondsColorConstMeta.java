package org.demo.documentation.dateytimewithseconds.colorconst;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateTimeWithSecondsColorConstMeta extends FieldMetaBuilder<DateTimeWithSecondsColorConstDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateTimeWithSecondsColorConstDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				DateTimeWithSecondsColorConstDTO_.customField
		);
		fields.setRequired(
				DateTimeWithSecondsColorConstDTO_.customField
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<DateTimeWithSecondsColorConstDTO> fields,
			InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateTimeWithSecondsColorConstDTO_.customField);
		}
		//
	}


}