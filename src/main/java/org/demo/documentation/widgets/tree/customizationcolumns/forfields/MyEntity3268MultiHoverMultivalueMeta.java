package org.demo.documentation.widgets.tree.customizationcolumns.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3268MultiHoverMultivalueMeta extends FieldMetaBuilder<MyEntity3268MultiHoverMultivalueDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3268MultiHoverMultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3268MultiHoverMultivalueDTO_.id);
		fields.setEnabled(MyEntity3268MultiHoverMultivalueDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3268MultiHoverMultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
