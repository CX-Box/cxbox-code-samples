package org.demo.documentation.feature.drilldown.drilldowntooltip;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3626Meta extends FieldMetaBuilder<MyExample3626DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3626DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		// --8<-- [start:drilldownById]
		// drill-down to view by bc record id: tooltip buttons open / copy this link
		fields.setDrilldown(
				MyExample3626DTO_.customFieldDrillDown,
				DrillDownType.INNER,
				"/screen/myexample3626/view/myexample3626info/" + CxboxMyExample3626Controller.myexample3626 + "/" + id
		);
		// --8<-- [end:drilldownById]
		// --8<-- [start:drilldownExternal]
		// drill-down of any type gets the tooltip, e.g. EXTERNAL_NEW
		fields.setDrilldown(
				MyExample3626DTO_.customFieldExternalDrillDown,
				DrillDownType.EXTERNAL_NEW,
				"https://doc.cxbox.org/features/element/drilldown/drilldown/"
		);
		// --8<-- [end:drilldownExternal]
		// --8<-- [start:drilldownFiltration]
		// drill-down to view with fields filtration: tooltip is shown,
		// but its buttons only show a warning (not supported yet)
		String urlFilter = URLEncoder.encode("customField.contains=data", StandardCharsets.UTF_8);
		fields.setDrilldown(
				MyExample3626DTO_.customFieldFilterDrillDown,
				DrillDownType.INNER,
				"/screen/myexample3626/view/myexample3626list/" + CxboxMyExample3626Controller.myexample3626
						+ "?filters={\"" + CxboxMyExample3626Controller.myexample3626 + "\":\"" + urlFilter + "\"}"
		);
		// --8<-- [end:drilldownFiltration]
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3626DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3626DTO_.customField);
	}

}
