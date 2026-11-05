package org.demo.documentation.widgets.dualaxes2d.drilldown;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4286ListMeta extends FieldMetaBuilder<MyExample4286ListDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4286ListDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4286ListDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample4286ListDTO_.month, MyExample4286ListDTO_.productName);
	}
}
