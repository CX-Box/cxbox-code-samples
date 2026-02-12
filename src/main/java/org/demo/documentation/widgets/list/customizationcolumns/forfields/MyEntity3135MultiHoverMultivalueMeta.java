package org.demo.documentation.widgets.list.customizationcolumns.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3135MultiHoverMultivalueMeta extends FieldMetaBuilder<MyEntity3135MultiHoverMultivalueDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3135MultiHoverMultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3135MultiHoverMultivalueDTO_.id);
		fields.setEnabled(MyEntity3135MultiHoverMultivalueDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3135MultiHoverMultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
