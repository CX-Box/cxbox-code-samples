package org.demo.documentation.date.ro;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateCreateEditMeta extends FieldMetaBuilder<DateCreateEditDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateCreateEditDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<DateCreateEditDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateCreateEditDTO_.customField);
		}
		//
	}


}