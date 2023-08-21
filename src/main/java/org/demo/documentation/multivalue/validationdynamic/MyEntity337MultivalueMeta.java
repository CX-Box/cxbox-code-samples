package org.demo.documentation.multivalue.validationdynamic;

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
public class MyEntity337MultivalueMeta extends FieldMetaBuilder<MyEntity337MultivalueDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity337MultivalueDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyEntity337MultivalueDTO_.id);
		fields.setEnabled(MyEntity337MultivalueDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity337MultivalueDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

	}

}
