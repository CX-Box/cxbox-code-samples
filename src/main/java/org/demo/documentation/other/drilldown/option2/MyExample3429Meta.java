package org.demo.documentation.other.drilldown.option2;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3429Meta extends FieldMetaBuilder<MyExample3429DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3429DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3429DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3429DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}