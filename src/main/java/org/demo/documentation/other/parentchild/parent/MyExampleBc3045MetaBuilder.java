package org.demo.documentation.other.parentchild.parent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.date.drilldown.CxboxDateDrillDownController;
import org.demo.documentation.fields.date.drilldown.DateDrillDownDTO_;
import org.demo.documentation.other.parentchild.PlatformMyExample3045Controller;
import org.springframework.stereotype.Service;

@Service
public class MyExampleBc3045MetaBuilder extends FieldMetaBuilder<MyExampleBc3045DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExampleBc3045DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(MyExampleBc3045DTO_.customFieldDrilldown);
		fields.setEnabled(MyExampleBc3045DTO_.customField);
		fields.setEnabled(
				MyExampleBc3045DTO_.id
		);
		fields.setDrilldown(MyExampleBc3045DTO_.customFieldDrilldown,
				DrillDownType.INNER,
				"/screen/myexample3045/view/myexample3045list/" + PlatformMyExample3045Controller.myExampleBc3045 + "/" + id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExampleBc3045DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExampleBc3045DTO_.customFieldDrilldown);
		fields.enableFilter(MyExampleBc3045DTO_.customField);
		fields.enableFilter(MyExampleBc3045DTO_.id);
	}

}
