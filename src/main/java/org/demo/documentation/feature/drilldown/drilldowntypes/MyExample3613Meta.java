package org.demo.documentation.feature.drilldown.drilldowntypes;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3613Meta extends FieldMetaBuilder<MyExample3613DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3613DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3613DTO_.customFieldRelativeNew);
		fields.setEnabled(MyExample3613DTO_.customFieldRelative);
		fields.setEnabled(MyExample3613DTO_.customFieldExternalNew);
		fields.setEnabled(MyExample3613DTO_.customFieldExternal);
		fields.setEnabled(MyExample3613DTO_.customField);
		fields.setRequired(MyExample3613DTO_.customField);
		// --8<-- [start:buildRowDependentMetaEXTERNAL]
		fields.setDrilldown(
				MyExample3613DTO_.customFieldExternal,
				DrillDownType.EXTERNAL,
				"https://cxbox.org/"
		);
		// --8<-- [end:buildRowDependentMetaEXTERNAL]
		// --8<-- [start:buildRowDependentMetaEXTERNAL_NEW]
		fields.setDrilldown(
				MyExample3613DTO_.customFieldExternalNew,
				DrillDownType.EXTERNAL_NEW,
				"https://cxbox.org/"
		);
		// --8<-- [end:buildRowDependentMetaEXTERNAL_NEW]
		// --8<-- [start:buildRowDependentMetaINNER]
		fields.setDrilldown(
				MyExample3613DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample3613/view/myexample3613form/" + CxboxMyExample3613Controller.myexample3613 + "/" + id
		);
		// --8<-- [end:buildRowDependentMetaINNER]
		// --8<-- [start:buildRowDependentMetaRELATIVE]
		fields.setDrilldown(
				MyExample3613DTO_.customFieldRelative,
				DrillDownType.RELATIVE,
				"/screen/myexample3613/view/myexample3613form/" + CxboxMyExample3613Controller.myexample3613 + "/" + id
		);
		// --8<-- [end:buildRowDependentMetaRELATIVE]
		// --8<-- [start:buildRowDependentMetaRELATIVE_NEW]
		fields.setDrilldown(
				MyExample3613DTO_.customFieldRelativeNew,
				DrillDownType.RELATIVE_NEW,
				"/screen/myexample3613/view/myexample3613form/" + CxboxMyExample3613Controller.myexample3613 + "/" + id
		);
		// --8<-- [end:buildRowDependentMetaRELATIVE_NEW]
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3613DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3613DTO_.customFieldRelativeNew);
		fields.enableFilter(MyExample3613DTO_.customFieldRelative);
		fields.enableFilter(MyExample3613DTO_.customFieldExternalNew);
		fields.enableFilter(MyExample3613DTO_.customFieldExternal);
	}

}