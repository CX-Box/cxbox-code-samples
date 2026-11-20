package org.demo.documentation.feature.drilldown.drilldownkey;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3627Meta extends FieldMetaBuilder<MyExample3627DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3627DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample3627DTO_.customField);
		// drill-down of a field without "drillDownKey" in the widget
		fields.setDrilldown(
				MyExample3627DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample3627/view/myexample3627meta/" + CxboxMyExample3627Controller.myexample3627 + "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3627DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3627DTO_.customField);
	}

}
