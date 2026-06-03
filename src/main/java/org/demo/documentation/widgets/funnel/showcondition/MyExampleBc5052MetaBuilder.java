package org.demo.documentation.widgets.funnel.showcondition;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExampleBc5052MetaBuilder extends AnySourceFieldMetaBuilder<MyExampleBc5052DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExampleBc5052DTO> fields, BcDescription bcDescription, String id,
	                                  String parentId) {
		fields.setEnabled(MyExampleBc5052DTO_.funnelKey);
		fields.setEnabled(MyExampleBc5052DTO_.amount);
		fields.setEnabled(
				org.demo.documentation.widgets.funnel.showcondition.MyExampleBc5052DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExampleBc5052DTO> fields, BcDescription bcDescription, String parentId) {
		fields.enableFilter(MyExampleBc5052DTO_.funnelKey);
		fields.enableFilter(MyExampleBc5052DTO_.amount);
		fields.enableFilter(
				org.demo.documentation.widgets.funnel.showcondition.MyExampleBc5052DTO_.id);
		fields.enableSort(
				org.demo.documentation.widgets.funnel.showcondition.MyExampleBc5052DTO_.id);
	}

}
