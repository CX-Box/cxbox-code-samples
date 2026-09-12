package org.demo.documentation.widgets.picktree.allpropertiesfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3357Meta extends FieldMetaBuilder<MyExample3357DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3357DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3357DTO_.customFieldPickTreeId);
		fields.setEnabled(MyExample3357DTO_.customFieldPickTree);
		fields.setEnabled(MyExample3357DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3357DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3357DTO_.customFieldPickTree);
	}

}