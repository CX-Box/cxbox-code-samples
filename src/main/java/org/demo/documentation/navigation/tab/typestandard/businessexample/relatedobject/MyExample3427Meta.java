package org.demo.documentation.navigation.tab.typestandard.businessexample.relatedobject;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.navigation.tab.typestandard.businessexample.CxboxMyExample3428Controller;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3427Meta extends FieldMetaBuilder<MyExample3427DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3427DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3427DTO_.customField);
		fields.setRequired(MyExample3427DTO_.customField);
		fields.setDrilldown(
				MyExample3427DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample3428/view/agreementinfo/" + CxboxMyExample3428Controller.myexample3428 + "/" + parentId + "/" + CxboxMyExample3428Controller.myexample3427 + "/" + id
		);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3427DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}