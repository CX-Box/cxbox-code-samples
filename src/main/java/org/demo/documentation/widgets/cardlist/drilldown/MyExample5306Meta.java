package org.demo.documentation.widgets.cardlist.drilldown;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.cxbox.core.dto.DrillDownType;
import org.springframework.stereotype.Service;

@Service
public class MyExample5306Meta extends FieldMetaBuilder<MyExample5306DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5306DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5306DTO_.document,
				MyExample5306DTO_.documentId,
				MyExample5306DTO_.customField,
				MyExample5306DTO_.customFieldDescription
		);
		// --8<-- [start:drilldown]
		fields.setDrilldown(
				MyExample5306DTO_.document,
				DrillDownType.INNER,
				"/screen/myexample5306/view/myexample5306form/" + CxboxMyExample5306Controller.myexample5306 + "/" + id
		);
		// --8<-- [end:drilldown]
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5306DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5306DTO_.customField);
	}

}
