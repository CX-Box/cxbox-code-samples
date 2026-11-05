package org.demo.documentation.widgets.relationGraph.drilldown;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;
import org.cxbox.core.dto.DrillDownType;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample6158Meta extends AnySourceFieldMetaBuilder<MyExample6158DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6158DTO> fields, BcDescription bc,
									  String id, String parentId) {
		var companyId = fields.getCurrentValue(MyExample6158DTO_.targetNodeId).orElse(null);
		var url = "/screen/myexample6158/view/myexample6158info/" + PlatformMyExample6158Controller.myExampleBc6158Company + "/" + companyId;
		fields.setDrilldown(MyExample6158DTO_.targetNodeId, DrillDownType.INNER, url);
		fields.setDrilldown(MyExample6158DTO_.edgeValue, DrillDownType.INNER, url);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample6158DTO> fields, BcDescription bc, String parentId) {
	}
}
