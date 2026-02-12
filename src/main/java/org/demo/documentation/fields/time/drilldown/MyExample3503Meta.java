package org.demo.documentation.fields.time.drilldown;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3503Meta extends FieldMetaBuilder<MyExample3503DTO> {
	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3503DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3503DTO_.customField);
		fields.setDrilldown(
				MyExample3503DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample3503/view/myexample3503form/" + PlatformMyExample3503Controller.myExampleBc3503 + "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3503DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3503DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}