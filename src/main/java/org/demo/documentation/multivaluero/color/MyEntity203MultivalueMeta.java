package org.demo.documentation.multivaluero.color;

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
public class MyEntity203MultivalueMeta extends FieldMetaBuilder<MyEntity203MultivalueDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity203MultivalueDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.multivaluero.color.MyEntity203MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.multivaluero.color.MyEntity203MultivalueDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity203MultivalueDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

	}

}
