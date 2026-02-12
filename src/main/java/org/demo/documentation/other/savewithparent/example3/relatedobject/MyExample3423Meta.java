package org.demo.documentation.other.savewithparent.example3.relatedobject;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.savewithparent.example3.CxboxMyExample3422Controller;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3423Meta extends FieldMetaBuilder<MyExample3423DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3423DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3423DTO_.customField);
		fields.setRequired(MyExample3423DTO_.customField);
		fields.setDrilldown(
				MyExample3423DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample3422/view/agreementinfo/" + CxboxMyExample3422Controller.myexample3422 + "/" + parentId + "/" + CxboxMyExample3422Controller.myexample3423 + "/" + id
		);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3423DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}