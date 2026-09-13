package org.demo.documentation.widgets.picktree.actions.cancelcreate;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3356Meta extends FieldMetaBuilder<MyExample3356DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3356DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3356DTO_.customFieldPickTreePostActionId);
		fields.setEnabled(MyExample3356DTO_.customFieldPickTreePostAction);
		fields.setEnabled(MyExample3356DTO_.customFieldPickTreeOnCancelId);
		fields.setEnabled(MyExample3356DTO_.customFieldPickTreeOnCancel);
		fields.setEnabled(MyExample3356DTO_.customFieldPickTreeId);
		fields.setEnabled(MyExample3356DTO_.customFieldPickTree);
		fields.setEnabled(MyExample3356DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3356DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3356DTO_.customFieldPickTreePostAction);
		fields.enableFilter(MyExample3356DTO_.customFieldPickTreeOnCancel);
		fields.enableFilter(MyExample3356DTO_.customFieldPickTree);
	}

}