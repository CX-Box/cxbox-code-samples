package org.demo.documentation.fields.multivalue.validationannotation;

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
public class MyEntity199MultivalueMeta extends FieldMetaBuilder<MyEntity199MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity199MultivalueDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivalue.validationannotation.MyEntity199MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.multivalue.validationannotation.MyEntity199MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity199MultivalueDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyEntity199MultivalueDTO_.customField);
		fields.enableSort(MyEntity199MultivalueDTO_.customField);
		fields.enableSort(MyEntity199MultivalueDTO_.id);
	}

}
