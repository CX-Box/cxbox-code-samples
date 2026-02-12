package org.demo.documentation.widgets.picklist.actions.cancelcreate.oncancel;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3198PickOnCancelPickMeta extends FieldMetaBuilder<MyEntity3198PickOnCancelPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3198PickOnCancelPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3198PickOnCancelPickDTO_.id);
		fields.setEnabled(MyEntity3198PickOnCancelPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3198PickOnCancelPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
