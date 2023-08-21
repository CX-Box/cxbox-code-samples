package org.demo.documentation.datetime.ro;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateTimeEditMeta extends FieldMetaBuilder<DateTimeEditDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateTimeEditDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		//
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<DateTimeEditDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

		//
	}


}