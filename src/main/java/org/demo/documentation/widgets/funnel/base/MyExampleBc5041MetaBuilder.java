package org.demo.documentation.widgets.funnel.base;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExampleBc5041MetaBuilder extends AnySourceFieldMetaBuilder<MyExampleBc5041DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExampleBc5041DTO> fields, BcDescription bcDescription, String id,
	                                  String parentId) {
		fields.setEnabled(MyExampleBc5041DTO_.funnelKey);
		fields.setEnabled(MyExampleBc5041DTO_.amount);
		fields.setEnabled(
				org.demo.documentation.widgets.funnel.base.MyExampleBc5041DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExampleBc5041DTO> fields, BcDescription bcDescription, String parentId) {
		fields.enableFilter(MyExampleBc5041DTO_.funnelKey);
		fields.enableFilter(MyExampleBc5041DTO_.amount);
		fields.enableFilter(
				org.demo.documentation.widgets.funnel.base.MyExampleBc5041DTO_.id);
		fields.enableSort(
				org.demo.documentation.widgets.funnel.base.MyExampleBc5041DTO_.id);
	}

}
