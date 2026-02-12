package org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.inlinepicklist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3092PickPick0Meta extends FieldMetaBuilder<MyEntity3092PickPick0DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3092PickPick0DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3092PickPick0DTO_.id);
		fields.setEnabled(MyEntity3092PickPick0DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3092PickPick0DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
