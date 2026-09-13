package org.demo.documentation.widgets.picktree.customizationcolumns;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3352Meta extends FieldMetaBuilder<MyExample3352DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3352DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3352DTO_.customFieldPicktreeId);
		fields.setEnabled(MyExample3352DTO_.customFieldPicktree);
		fields.setEnabled(MyExample3352DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3352DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3352DTO_.customFieldPicktree);
	}

}