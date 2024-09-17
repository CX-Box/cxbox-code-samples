package org.demo.documentation.widgets.picklist.actions.createcustomsave;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3073PickPickMeta extends FieldMetaBuilder<MyEntity3073PickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3073PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3073PickPickDTO_.id);
		fields.setEnabled(MyEntity3073PickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3073PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableSort(MyEntity3073PickPickDTO_.id);
		fields.enableSort(MyEntity3073PickPickDTO_.customField);

	}

}
