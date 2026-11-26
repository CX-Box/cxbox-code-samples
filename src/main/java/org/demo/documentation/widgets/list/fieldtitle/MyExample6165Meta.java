package org.demo.documentation.widgets.list.fieldtitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample6165Meta extends FieldMetaBuilder<MyExample6165DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6165DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample6165DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample6165DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample6165DTO_.customField);
		fields.enableSort(MyExample6165DTO_.customField);
	}
}
