package org.demo.documentation.widgets.funnel.icon.withouticon;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExampleBc5051MetaBuilder extends AnySourceFieldMetaBuilder<MyExampleBc5051DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExampleBc5051DTO> fields, BcDescription bcDescription, String id,
	                                  String parentId) {
		fields.setEnabled(MyExampleBc5051DTO_.funnelKey);
		fields.setEnabled(MyExampleBc5051DTO_.amount);
		fields.setEnabled(
				org.demo.documentation.widgets.funnel.icon.withouticon.MyExampleBc5051DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExampleBc5051DTO> fields, BcDescription bcDescription, String parentId) {
		fields.enableFilter(MyExampleBc5051DTO_.funnelKey);
		fields.enableFilter(MyExampleBc5051DTO_.amount);
		fields.enableFilter(
				org.demo.documentation.widgets.funnel.icon.withouticon.MyExampleBc5051DTO_.id);
		fields.enableSort(
				org.demo.documentation.widgets.funnel.icon.withouticon.MyExampleBc5051DTO_.id);
	}

}
