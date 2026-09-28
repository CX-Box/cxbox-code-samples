package org.demo.documentation.fields.multivaluetree.required;

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
public class MyEntity3321MultivalueMeta extends FieldMetaBuilder<MyEntity3321MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3321MultivalueDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivaluetree.required.MyEntity3321MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3321MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3321MultivalueDTO_.parentId);
		fields.enableFilter(MyEntity3321MultivalueDTO_.customField);
		fields.enableSort(MyEntity3321MultivalueDTO_.customField);
		fields.enableSort(MyEntity3321MultivalueDTO_.id);
	}
	// --8<-- [end:buildIndependentMeta]

}
