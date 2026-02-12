package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forassoc.innersource;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3870Meta extends FieldMetaBuilder<MyExample3870DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3870DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3870DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3870DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}