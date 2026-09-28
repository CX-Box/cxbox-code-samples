package org.demo.documentation.widgets.assoctree.actions.other.buttonassoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3333MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3333MultiMultivalueDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3333MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3333MultiMultivalueDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3333MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3333MultiMultivalueDTO_.parentId);
		fields.enableSort(MyEntity3333MultiMultivalueDTO_.id);
		fields.enableSort(MyEntity3333MultiMultivalueDTO_.customField);

	}

}
