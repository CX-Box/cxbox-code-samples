package org.demo.documentation.widgets.picklist.actions.edit;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3092Meta extends FieldMetaBuilder<MyExample3092DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3092DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3092DTO_.customFieldInlinePickListId);
		fields.setEnabled(MyExample3092DTO_.customFieldInlinePickList);
		fields.setEnabled(MyExample3092DTO_.customFieldPickListId);
		fields.setEnabled(MyExample3092DTO_.customFieldPickList);
		fields.setEnabled(MyExample3092DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3092DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3092DTO_.customFieldInlinePickList);
		fields.enableFilter(MyExample3092DTO_.customFieldPickList);
	}

}