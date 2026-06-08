package org.demo.documentation.widgets.funnel.drilldown.drilldown;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExampleBc5047MetaBuilder extends AnySourceFieldMetaBuilder<MyExampleBc5047DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExampleBc5047DTO> fields, BcDescription bcDescription, String id,
	                                  String parentId) {
		fields.setEnabled(MyExampleBc5047DTO_.funnelKey);
		fields.setEnabled(MyExampleBc5047DTO_.amount);
		fields.setEnabled(
				org.demo.documentation.widgets.funnel.drilldown.drilldown.MyExampleBc5047DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExampleBc5047DTO> fields, BcDescription bcDescription, String parentId) {
		fields.enableFilter(MyExampleBc5047DTO_.funnelKey);
		fields.enableFilter(MyExampleBc5047DTO_.amount);
		fields.enableFilter(
				org.demo.documentation.widgets.funnel.drilldown.drilldown.MyExampleBc5047DTO_.id);
		fields.enableSort(
				org.demo.documentation.widgets.funnel.drilldown.drilldown.MyExampleBc5047DTO_.id);
	}

}
