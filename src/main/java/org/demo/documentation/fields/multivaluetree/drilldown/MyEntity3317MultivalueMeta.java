package org.demo.documentation.fields.multivaluetree.drilldown;

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
public class MyEntity3317MultivalueMeta extends FieldMetaBuilder<MyEntity3317MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3317MultivalueDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivaluetree.drilldown.MyEntity3317MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3317MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3317MultivalueDTO_.parentId);
		fields.enableFilter(MyEntity3317MultivalueDTO_.customField);
		fields.enableSort(MyEntity3317MultivalueDTO_.customField);
		fields.enableSort(MyEntity3317MultivalueDTO_.id);
	}
	// --8<-- [end:buildIndependentMeta]

}
