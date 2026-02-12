package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forpicklist.innersource;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3869Meta extends FieldMetaBuilder<MyExample3869DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3869DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3869DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3869DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}