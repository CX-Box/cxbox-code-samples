package org.demo.documentation.fields.multivaluetree.basic;

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
public class MyEntity3314MultivalueMeta extends FieldMetaBuilder<MyEntity3314MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3314MultivalueDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3314MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3314MultivalueDTO_.parentId);
		fields.enableFilter(MyEntity3314MultivalueDTO_.customField);
		fields.enableSort(MyEntity3314MultivalueDTO_.customField);
		fields.enableSort(MyEntity3314MultivalueDTO_.id);
	}
	// --8<-- [end:buildIndependentMeta]

}
