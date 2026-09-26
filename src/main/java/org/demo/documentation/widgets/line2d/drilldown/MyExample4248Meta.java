package org.demo.documentation.widgets.line2d.drilldown;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;
import org.cxbox.core.dto.DrillDownType;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4248Meta extends AnySourceFieldMetaBuilder<MyExample4248DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4248DTO> fields, BcDescription bc,
									  String id, String parentId) {
		var month = fields.getCurrentValue(MyExample4248DTO_.monthNumber).orElse(null);
		var product = fields.getCurrentValue(MyExample4248DTO_.productName).orElse(null);
		fields.setDrilldownWithFilter(
				MyExample4248DTO_.month,
				DrillDownType.INNER,
				"/screen/myexample4248/view/myexample4248list",
				fc -> fc
						.add(PlatformMyExample4248Controller.myExampleBc4248List, MyExample4248ListDTO.class, fb -> fb
								.number(MyExample4248ListDTO_.month, month)
								.dictionaryEnum(MyExample4248ListDTO_.productName, product))
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4248DTO> fields, BcDescription bc, String parentId) {
	}
}
