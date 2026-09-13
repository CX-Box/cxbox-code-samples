package org.demo.documentation.fields.multivaluetree.colorconst;

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
public class MyEntity3316MultivalueMeta extends FieldMetaBuilder<MyEntity3316MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3316MultivalueDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivaluetree.colorconst.MyEntity3316MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.multivaluetree.colorconst.MyEntity3316MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3316MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3316MultivalueDTO_.parentId);
		fields.enableFilter(MyEntity3316MultivalueDTO_.customField);
		fields.enableSort(MyEntity3316MultivalueDTO_.customField);
		fields.enableSort(MyEntity3316MultivalueDTO_.id);
	}

}
