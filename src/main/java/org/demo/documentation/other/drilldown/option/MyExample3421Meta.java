package org.demo.documentation.other.drilldown.option;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3421Meta extends FieldMetaBuilder<MyExample3421DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3421DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3421DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3421DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}