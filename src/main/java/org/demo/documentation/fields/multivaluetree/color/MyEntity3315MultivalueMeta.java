package org.demo.documentation.fields.multivaluetree.color;

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
public class MyEntity3315MultivalueMeta extends FieldMetaBuilder<MyEntity3315MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3315MultivalueDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivaluetree.color.MyEntity3315MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.multivaluetree.color.MyEntity3315MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3315MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3315MultivalueDTO_.parentId);
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyEntity3315MultivalueDTO_.customField);
		}
		fields.enableFilter(MyEntity3315MultivalueDTO_.customField);
		fields.enableSort(MyEntity3315MultivalueDTO_.customField);
		fields.enableSort(MyEntity3315MultivalueDTO_.id);
	}
	// --8<-- [end:buildIndependentMeta]
}
