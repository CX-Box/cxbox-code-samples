package org.demo.documentation.widgets.picklist.allpropertiesfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3405Meta extends FieldMetaBuilder<MyExample3405DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3405DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3405DTO_.customFieldPickListId);
		fields.setEnabled(MyExample3405DTO_.customFieldPickList);
		fields.setEnabled(MyExample3405DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3405DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3405DTO_.customFieldPickList);
	}

}