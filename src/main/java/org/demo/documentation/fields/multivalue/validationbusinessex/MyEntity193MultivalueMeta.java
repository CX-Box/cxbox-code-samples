package org.demo.documentation.fields.multivalue.validationbusinessex;

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
public class MyEntity193MultivalueMeta extends FieldMetaBuilder<MyEntity193MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity193MultivalueDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivalue.validationbusinessex.MyEntity193MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.multivalue.validationbusinessex.MyEntity193MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity193MultivalueDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyEntity193MultivalueDTO_.customField);
		fields.enableSort(MyEntity193MultivalueDTO_.customField);
		fields.enableSort(MyEntity193MultivalueDTO_.id);
	}

}
