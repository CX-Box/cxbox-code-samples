package org.demo.documentation.widgets.picktree.actions.delete.forpicktreepopup;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3354PickPickMeta extends FieldMetaBuilder<MyEntity3354PickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3354PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3354PickPickDTO_.id);
		fields.setEnabled(MyEntity3354PickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3354PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3354PickPickDTO_.parentId);

	}

}
