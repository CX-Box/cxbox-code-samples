package org.demo.documentation.multivaluehover.placeholder;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample235Meta extends FieldMetaBuilder<MyExample235DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample235DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample235DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample235DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample235DTO_.customField);
		}
		fields.enableFilter(MyExample235DTO_.customField);
	}

}