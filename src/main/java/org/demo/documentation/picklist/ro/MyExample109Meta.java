package org.demo.documentation.picklist.ro;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample109Meta extends FieldMetaBuilder<MyExample109DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample109DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample109DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample109DTO_.customField);
		}
		fields.enableFilter(MyExample109DTO_.customField);
	}

}