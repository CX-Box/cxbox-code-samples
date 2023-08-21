package org.demo.documentation.multivaluero.basic;

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
public class MyEntity201MultivalueMeta extends FieldMetaBuilder<MyEntity201MultivalueDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity201MultivalueDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.multivaluero.basic.MyEntity201MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.multivaluero.basic.MyEntity201MultivalueDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity201MultivalueDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

	}

}
