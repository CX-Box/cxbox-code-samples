package org.demo.documentation.multivalue.placeholder;

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
public class MyEntity187MultivalueMeta extends FieldMetaBuilder<MyEntity187MultivalueDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity187MultivalueDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.multivalue.placeholder.MyEntity187MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.multivalue.placeholder.MyEntity187MultivalueDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity187MultivalueDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

	}

}
