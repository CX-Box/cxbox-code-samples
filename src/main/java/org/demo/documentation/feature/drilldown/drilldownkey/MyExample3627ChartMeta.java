package org.demo.documentation.feature.drilldown.drilldownkey;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3627ChartMeta extends AnySourceFieldMetaBuilder<MyExample3627ChartDTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3627ChartDTO> fields, BcDescription bc,
			String id, String parentId) {
		// the second bar has no link: a click on it opens nothing
		if ("1".equals(id)) {
			fields.setDrilldown(
					MyExample3627ChartDTO_.name,
					DrillDownType.INNER,
					"/screen/myexample3627/view/myexample3627list"
			);
		}
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3627ChartDTO> fields, BcDescription bc, String parentId) {
	}

}
