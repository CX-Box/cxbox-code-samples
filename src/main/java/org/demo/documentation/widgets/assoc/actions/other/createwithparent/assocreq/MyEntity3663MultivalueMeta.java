package org.demo.documentation.widgets.assoc.actions.other.createwithparent.assocreq;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3663MultivalueMeta extends FieldMetaBuilder<MyEntity3663MultivalueDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3663MultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3663MultivalueDTO_.id);
		fields.setEnabled(MyEntity3663MultivalueDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3663MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableSort(MyEntity3663MultivalueDTO_.id);
		fields.enableSort(MyEntity3663MultivalueDTO_.customField);
	}

}
