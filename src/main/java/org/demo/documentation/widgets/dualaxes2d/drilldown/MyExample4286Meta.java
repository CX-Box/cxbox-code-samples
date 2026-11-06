package org.demo.documentation.widgets.dualaxes2d.drilldown;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;
import org.cxbox.core.dto.DrillDownType;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4286Meta extends AnySourceFieldMetaBuilder<MyExample4286DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4286DTO> fields, BcDescription bc,
									  String id, String parentId) {
		var month = fields.getCurrentValue(MyExample4286DTO_.monthNumber).orElse(null);
		var product = fields.getCurrentValue(MyExample4286DTO_.productName).orElse(null);
		fields.setDrilldownWithFilter(
				MyExample4286DTO_.month,
				DrillDownType.INNER,
				"/screen/myexample4286/view/myexample4286list",
				fc -> fc
						.add(PlatformMyExample4286Controller.myExampleBc4286List, MyExample4286ListDTO.class, fb -> fb
								.number(MyExample4286ListDTO_.month, month)
								.dictionaryEnum(MyExample4286ListDTO_.productName, product))
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4286DTO> fields, BcDescription bc, String parentId) {
	}
}
