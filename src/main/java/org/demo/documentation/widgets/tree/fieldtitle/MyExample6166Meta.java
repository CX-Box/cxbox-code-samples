package org.demo.documentation.widgets.tree.fieldtitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample6166Meta extends FieldMetaBuilder<MyExample6166DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6166DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setDisabled(MyExample6166DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample6166DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample6166DTO_.customField);
		fields.enableSort(MyExample6166DTO_.customField);
	}
}
