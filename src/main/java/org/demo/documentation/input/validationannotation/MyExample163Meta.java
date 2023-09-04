package org.demo.documentation.input.validationannotation;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample163Meta extends FieldMetaBuilder<MyExample163DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample163DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample163DTO_.customField);
		fields.setPlaceholder(MyExample163DTO_.customField, "Not null");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample163DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample163DTO_.customField);
		}
		fields.enableFilter(MyExample163DTO_.customField);
	}

}