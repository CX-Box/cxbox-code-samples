package org.demo.documentation.multivaluehover.basic;

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
public class MyEntity259MultivalueMeta extends FieldMetaBuilder<MyEntity259MultivalueDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity259MultivalueDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.multivaluehover.basic.MyEntity259MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.multivaluehover.basic.MyEntity259MultivalueDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity259MultivalueDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

	}

}
