package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel.enums.CustomFieldDictionaryLevelTwoEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3157Meta extends FieldMetaBuilder<MyExample3157DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3157DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample3157DTO_.customFieldDictionaryLevelTwo, CustomFieldDictionaryLevelTwoEnum.values());
		fields.setEnabled(MyExample3157DTO_.customFieldDictionaryLevelTwo);
		fields.setEnumValues(MyExample3157DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample3157DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3157DTO_.customField);
	}

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3157DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.setEnumFilterValues(
				fields,
				MyExample3157DTO_.customFieldDictionaryLevelTwo,
				CustomFieldDictionaryLevelTwoEnum.values()
		);
		fields.enableFilter(MyExample3157DTO_.customFieldDictionaryLevelTwo);
		fields.setEnumFilterValues(fields, MyExample3157DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3157DTO_.customFieldDictionary);
		fields.defaultGroupingHierarchy(
				MyExample3157DTO_.customFieldDictionary,
				MyExample3157DTO_.customFieldDictionaryLevelTwo,
				lvl -> lvl
						.add(
								CustomFieldDictionaryEnum.LEVEL_1_HIGH,
								lvl2 -> lvl2
										.add(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE)
										.add(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_HIGH)
						)
						.add(
								CustomFieldDictionaryEnum.LEVEL_1_MIDDLE
						)
		);
	}
	// --8<-- [end:buildIndependentMeta]
}