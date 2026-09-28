package org.demo.documentation.fields.multivaluetree.primary;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3320MultivalueMeta extends FieldMetaBuilder<MyEntity3320MultivalueDTO> {
	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3320MultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivaluetree.primary.MyEntity3320MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3320MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3320MultivalueDTO_.parentId);
		fields.enableFilter(MyEntity3320MultivalueDTO_.customField);
		fields.enableSort(MyEntity3320MultivalueDTO_.customField);
		fields.enableSort(MyEntity3320MultivalueDTO_.id);
	}
	// --8<-- [end:buildIndependentMeta]
}
