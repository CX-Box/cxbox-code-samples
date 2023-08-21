package org.demo.documentation.multivaluehover.validationruntimeex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample245Meta extends FieldMetaBuilder<MyExample245DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample245DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample245DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

	}

}