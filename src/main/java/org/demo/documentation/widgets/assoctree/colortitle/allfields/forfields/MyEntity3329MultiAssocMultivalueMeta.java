package org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3329MultiAssocMultivalueMeta extends FieldMetaBuilder<MyEntity3329MultiAssocMultivalueDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3329MultiAssocMultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3329MultiAssocMultivalueDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3329MultiAssocMultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3329MultiAssocMultivalueDTO_.parentId);

	}

}
