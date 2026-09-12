package org.demo.documentation.fields.multivaluetree.validationdynamic;

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
public class MyEntity3327MultivalueMeta extends FieldMetaBuilder<MyEntity3327MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3327MultivalueDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3327MultivalueDTO_.id);
		fields.setEnabled(MyEntity3327MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3327MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3327MultivalueDTO_.parentId);
		fields.enableFilter(MyEntity3327MultivalueDTO_.customField);
		fields.enableSort(MyEntity3327MultivalueDTO_.customField);
		fields.enableSort(MyEntity3327MultivalueDTO_.id);
		fields.enableSort(MyEntity3327MultivalueDTO_.customFieldAdditional);
	}

}
