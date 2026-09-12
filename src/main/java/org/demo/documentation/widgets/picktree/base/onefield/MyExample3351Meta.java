package org.demo.documentation.widgets.picktree.base.onefield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3351Meta extends FieldMetaBuilder<MyExample3351DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3351DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3351DTO_.customFieldInlinePickTreeId);
		fields.setEnabled(MyExample3351DTO_.customFieldInlinePickTree);
		fields.setEnabled(MyExample3351DTO_.customFieldPickTreeId);
		fields.setEnabled(MyExample3351DTO_.customFieldPickTree);
		fields.setEnabled(MyExample3351DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3351DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3351DTO_.customFieldInlinePickTree);
		fields.enableFilter(MyExample3351DTO_.customFieldPickTree);
	}

}