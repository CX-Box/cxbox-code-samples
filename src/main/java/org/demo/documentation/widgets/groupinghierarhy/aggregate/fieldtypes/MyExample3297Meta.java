package org.demo.documentation.widgets.groupinghierarhy.aggregate.fieldtypes;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.fieldtypes.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3297Meta extends FieldMetaBuilder<MyExample3297DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3297DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample3297DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(
				MyExample3297DTO_.customFieldDictionary,
				MyExample3297DTO_.customField,
				MyExample3297DTO_.customFieldNumber,
				MyExample3297DTO_.customFieldMoney,
				MyExample3297DTO_.customFieldPercent,
				MyExample3297DTO_.customFieldDate,
				MyExample3297DTO_.customFieldDateTime,
				MyExample3297DTO_.customFieldInput
		);
		fields.setDrilldown(
				MyExample3297DTO_.customFieldNumber,
				DrillDownType.INNER,
				"/screen/myexample3297/view/myexample3297form/" + CxboxMyExample3297Controller.myexample3297 + "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3297DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setEnumFilterValues(fields, MyExample3297DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3297DTO_.customFieldDictionary);
	}

}
