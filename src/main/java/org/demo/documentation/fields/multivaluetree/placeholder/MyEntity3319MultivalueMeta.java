package org.demo.documentation.fields.multivaluetree.placeholder;

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
public class MyEntity3319MultivalueMeta extends FieldMetaBuilder<MyEntity3319MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3319MultivalueDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivaluetree.placeholder.MyEntity3319MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.multivaluetree.placeholder.MyEntity3319MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3319MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3319MultivalueDTO_.parentId);
		fields.enableFilter(MyEntity3319MultivalueDTO_.customField);
		fields.enableSort(MyEntity3319MultivalueDTO_.customField);
		fields.enableSort(MyEntity3319MultivalueDTO_.id);
	}

}
