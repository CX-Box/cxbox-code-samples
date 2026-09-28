package org.demo.documentation.widgets.picktree.base.onefield.picktreepopup.picktree;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3351PickPickMeta extends FieldMetaBuilder<MyEntity3351PickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3351PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3351PickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3351PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3351PickPickDTO_.parentId);

	}

}
