package org.demo.documentation.widgets.picktree.actions.edit;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3353Meta extends FieldMetaBuilder<MyExample3353DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3353DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3353DTO_.customFieldInlinePickTreeId);
		fields.setEnabled(MyExample3353DTO_.customFieldInlinePickTree);
		fields.setEnabled(MyExample3353DTO_.customFieldPickTreeId);
		fields.setEnabled(MyExample3353DTO_.customFieldPickTree);
		fields.setEnabled(MyExample3353DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3353DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3353DTO_.customFieldInlinePickTree);
		fields.enableFilter(MyExample3353DTO_.customFieldPickTree);
	}

}