package org.demo.documentation.dateytimewithseconds.placeholder;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateTimeWithSecondsPlaceholderMeta extends FieldMetaBuilder<DateTimeWithSecondsPlaceholderDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateTimeWithSecondsPlaceholderDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				DateTimeWithSecondsPlaceholderDTO_.customField
		);
		fields.setPlaceholder(DateTimeWithSecondsPlaceholderDTO_.customField, "29.05.2023 11:25:58");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<DateTimeWithSecondsPlaceholderDTO> fields,
			InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateTimeWithSecondsPlaceholderDTO_.customField);
		}
		//
	}


}