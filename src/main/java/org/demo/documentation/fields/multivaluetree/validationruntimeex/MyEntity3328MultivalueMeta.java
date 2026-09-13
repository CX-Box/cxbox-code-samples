package org.demo.documentation.fields.multivaluetree.validationruntimeex;

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
public class MyEntity3328MultivalueMeta extends FieldMetaBuilder<MyEntity3328MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3328MultivalueDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivaluetree.validationruntimeex.MyEntity3328MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.multivaluetree.validationruntimeex.MyEntity3328MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3328MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3328MultivalueDTO_.parentId);
		fields.enableFilter(MyEntity3328MultivalueDTO_.customField);
		fields.enableSort(MyEntity3328MultivalueDTO_.customField);
		fields.enableSort(MyEntity3328MultivalueDTO_.id);
	}

}
