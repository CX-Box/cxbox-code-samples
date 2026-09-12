package org.demo.documentation.widgets.picktree.actions.edit.picktreepopup.inlinepicktree;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3353PickPick0Meta extends FieldMetaBuilder<MyEntity3353PickPick0DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3353PickPick0DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3353PickPick0DTO_.id);
		fields.setEnabled(MyEntity3353PickPick0DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3353PickPick0DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3353PickPick0DTO_.parentId);

	}

}
