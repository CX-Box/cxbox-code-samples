package org.demo.documentation.widgets.cardcarousellist.drilldown;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.cxbox.core.dto.DrillDownType;
import org.springframework.stereotype.Service;

@Service
public class MyExample5066Meta extends FieldMetaBuilder<MyExample5066DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5066DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5066DTO_.document,
				MyExample5066DTO_.documentId,
				MyExample5066DTO_.customField,
				MyExample5066DTO_.customFieldDescription
		);
		// --8<-- [start:drilldown]
		fields.setDrilldown(
				MyExample5066DTO_.document,
				DrillDownType.INNER,
				"/screen/myexample5066/view/myexample5066form/" + CxboxMyExample5066Controller.myexample5066 + "/" + id
		);
		// --8<-- [end:drilldown]
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5066DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5066DTO_.customField);
	}

}
