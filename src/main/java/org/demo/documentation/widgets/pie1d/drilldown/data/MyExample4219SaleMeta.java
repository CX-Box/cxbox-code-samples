package org.demo.documentation.widgets.pie1d.drilldown.data;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4219SaleMeta extends FieldMetaBuilder<MyExample4219SaleDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4219SaleDTO> fields,
			InnerBcDescription bcDescription, Long id, Long parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4219SaleDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample4219SaleDTO_.customField);
	}

}
