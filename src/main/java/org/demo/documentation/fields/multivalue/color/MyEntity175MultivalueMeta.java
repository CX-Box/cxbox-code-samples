package org.demo.documentation.fields.multivalue.color;

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
public class MyEntity175MultivalueMeta extends FieldMetaBuilder<MyEntity175MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity175MultivalueDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivalue.color.MyEntity175MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.multivalue.color.MyEntity175MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity175MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyEntity175MultivalueDTO_.customField);
		}
		fields.enableFilter(MyEntity175MultivalueDTO_.customField);
		fields.enableSort(MyEntity175MultivalueDTO_.customField);
		fields.enableSort(MyEntity175MultivalueDTO_.id);
	}
	// --8<-- [end:buildIndependentMeta]
}
