package org.demo.documentation.widgets.line2d.drilldown;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4248ListMeta extends FieldMetaBuilder<MyExample4248ListDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4248ListDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4248ListDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample4248ListDTO_.month, MyExample4248ListDTO_.productName);
	}
}
