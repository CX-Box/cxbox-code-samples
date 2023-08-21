package org.demo.documentation.multivalue.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@RequiredArgsConstructor
@Service
public class MyEntity177MultivalueMeta extends FieldMetaBuilder<MyEntity177MultivalueDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity177MultivalueDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity177MultivalueDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

	}

}
