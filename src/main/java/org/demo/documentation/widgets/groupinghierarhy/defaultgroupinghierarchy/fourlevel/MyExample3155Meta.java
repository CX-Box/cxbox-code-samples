package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryLevelFourEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryLevelThreeEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryLevelTwoEnum;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MyExample3155Meta extends FieldMetaBuilder<MyExample3155DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3155DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample3155DTO_.customFieldDictionaryLevelFour, CustomFieldDictionaryLevelFourEnum.values());
		fields.setEnabled(MyExample3155DTO_.customFieldDictionaryLevelFour);
		fields.setEnumValues(
				MyExample3155DTO_.customFieldDictionaryLevelThree,
				CustomFieldDictionaryLevelThreeEnum.values()
		);
		fields.setEnabled(MyExample3155DTO_.customFieldDictionaryLevelThree);
		fields.setEnumValues(MyExample3155DTO_.customFieldDictionaryLevelTwo, CustomFieldDictionaryLevelTwoEnum.values());
		fields.setEnabled(MyExample3155DTO_.customFieldDictionaryLevelTwo);
		fields.setEnumValues(MyExample3155DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample3155DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3155DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3155DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.setEnumFilterValues(
				fields,
				MyExample3155DTO_.customFieldDictionaryLevelFour,
				CustomFieldDictionaryLevelFourEnum.values()
		);
		fields.enableFilter(MyExample3155DTO_.customFieldDictionaryLevelFour);
		fields.setEnumFilterValues(
				fields,
				MyExample3155DTO_.customFieldDictionaryLevelThree,
				CustomFieldDictionaryLevelThreeEnum.values()
		);
		fields.enableFilter(MyExample3155DTO_.customFieldDictionaryLevelThree);
		fields.setEnumFilterValues(
				fields,
				MyExample3155DTO_.customFieldDictionaryLevelTwo,
				CustomFieldDictionaryLevelTwoEnum.values()
		);
		fields.enableFilter(MyExample3155DTO_.customFieldDictionaryLevelTwo);
		fields.setEnumFilterValues(fields, MyExample3155DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3155DTO_.customFieldDictionary);
		fields.defaultGroupingHierarchy(
				MyExample3155DTO_.customFieldDictionary,
				lvl -> lvl
						.add(CustomFieldDictionaryEnum.LEVEL_1_HIGH)
						.add(CustomFieldDictionaryEnum.LEVEL_1_MIDDLE)
		);
	}

}