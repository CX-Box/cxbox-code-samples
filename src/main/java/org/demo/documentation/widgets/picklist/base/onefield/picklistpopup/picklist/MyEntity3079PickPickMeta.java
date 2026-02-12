package org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.picklist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3079PickPickMeta extends FieldMetaBuilder<MyEntity3079PickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3079PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3079PickPickDTO_.id);
		fields.setEnabled(MyEntity3079PickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3079PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
