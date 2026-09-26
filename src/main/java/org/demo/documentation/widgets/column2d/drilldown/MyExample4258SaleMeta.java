package org.demo.documentation.widgets.column2d.drilldown;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.column2d.data.MyEntity4252Product;
import org.springframework.stereotype.Service;

@Service
public class MyExample4258SaleMeta extends FieldMetaBuilder<MyExample4258SaleDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4258SaleDTO> fields,
			InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnumValues(MyExample4258SaleDTO_.product, MyEntity4252Product.values());
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4258SaleDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample4258SaleDTO_.clientName);
		fields.setEnumFilterValues(fields, MyExample4258SaleDTO_.product, MyEntity4252Product.values());
		fields.enableFilter(MyExample4258SaleDTO_.product);
	}

}
