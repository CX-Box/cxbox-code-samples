package org.demo.documentation.widgets.property.sethidden.graph.inner;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.property.sethidden.graph.inner.enums.ProductNameEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample5020Meta extends FieldMetaBuilder<MyExample5020DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5020DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample5020DTO_.sum);
		fields.setEnumValues(MyExample5020DTO_.productName, ProductNameEnum.values());
		fields.setEnabled(MyExample5020DTO_.productName);
		fields.setEnabled(MyExample5020DTO_.clientName);
		fields.setEnabled(MyExample5020DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5020DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5020DTO_.sum);
		fields.setEnumFilterValues(fields, MyExample5020DTO_.productName, ProductNameEnum.values());
		fields.enableFilter(MyExample5020DTO_.productName);
		fields.enableFilter(MyExample5020DTO_.clientName);
	}

}