package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryLevelThreeEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryLevelTwoEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3165Meta extends FieldMetaBuilder<MyExample3165DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3165DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample3165DTO_.customFieldDictionaryLevelTwo, CustomFieldDictionaryLevelTwoEnum.values());
		fields.setEnabled(MyExample3165DTO_.customFieldDictionaryLevelTwo);
		fields.setEnumValues(
				MyExample3165DTO_.customFieldDictionaryLevelThree,
				CustomFieldDictionaryLevelThreeEnum.values()
		);
		fields.setEnabled(MyExample3165DTO_.customFieldDictionaryLevelThree);
		fields.setEnumValues(MyExample3165DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample3165DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3165DTO_.customField);
	}

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3165DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.setEnumFilterValues(
				fields,
				MyExample3165DTO_.customFieldDictionaryLevelTwo,
				CustomFieldDictionaryLevelTwoEnum.values()
		);
		fields.enableFilter(MyExample3165DTO_.customFieldDictionaryLevelTwo);
		fields.setEnumFilterValues(
				fields,
				MyExample3165DTO_.customFieldDictionaryLevelThree,
				CustomFieldDictionaryLevelThreeEnum.values()
		);
		fields.enableFilter(MyExample3165DTO_.customFieldDictionaryLevelThree);
		fields.setEnumFilterValues(fields, MyExample3165DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3165DTO_.customFieldDictionary);
		fields.enableSort(MyExample3165DTO_.customFieldDictionaryLevelTwo);
		fields.enableSort(MyExample3165DTO_.customFieldDictionary);
		fields.enableSort(MyExample3165DTO_.customFieldDictionaryLevelThree);
		fields.defaultGroupingHierarchy(
				MyExample3165DTO_.customFieldDictionary,
				MyExample3165DTO_.customFieldDictionaryLevelTwo,
				MyExample3165DTO_.customFieldDictionaryLevelThree,
				lvl -> lvl
						.add(
								CustomFieldDictionaryEnum.LEVEL_1_HIGH,
								lvl2 -> lvl2
										.add(
												CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE,
												lvl3 -> lvl3
														.add(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE)
										)
						)
						.add(
								CustomFieldDictionaryEnum.LEVEL_1_MIDDLE,
								lvl2 -> lvl2
										.add(
												CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE,
												lvl3 -> lvl3
														.add(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE)
										)
						)
		);

	}
	// --8<-- [end:buildIndependentMeta]
}