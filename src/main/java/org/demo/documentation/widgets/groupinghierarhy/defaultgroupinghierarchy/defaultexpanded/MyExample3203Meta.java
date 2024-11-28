package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded.enums.CustomFieldDictionaryLevelThreeEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded.enums.CustomFieldDictionaryLevelTwoEnum;

import org.springframework.stereotype.Service;

@Service
public class MyExample3203Meta extends FieldMetaBuilder<MyExample3203DTO> {
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3203DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3203DTO_.customFieldDictionaryLevelThree);
        fields.setEnabled(MyExample3203DTO_.customFieldDictionaryLevelTwo);
        fields.setEnumValues(MyExample3203DTO_.customFieldDictionaryLevelTwo, CustomFieldDictionaryLevelTwoEnum.values());
        fields.setEnabled(MyExample3203DTO_.customFieldDictionaryLevelTwo);
        fields.setEnumValues(
                MyExample3203DTO_.customFieldDictionaryLevelThree,
                CustomFieldDictionaryLevelThreeEnum.values()
        );
        fields.setEnabled(MyExample3203DTO_.customFieldDictionaryLevelThree);
        fields.setEnumValues(MyExample3203DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3203DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3203DTO_.customField);
    }

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3203DTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.setEnumValues(MyExample3203DTO_.customFieldDictionaryLevelThree, CustomFieldDictionaryLevelThreeEnum.values());
        fields.setEnumFilterValues(fields, MyExample3203DTO_.customFieldDictionaryLevelThree, CustomFieldDictionaryLevelThreeEnum.values());
        fields.enableFilter(MyExample3203DTO_.customFieldDictionaryLevelThree);
        fields.setEnumValues(MyExample3203DTO_.customFieldDictionaryLevelTwo, CustomFieldDictionaryLevelTwoEnum.values());
        fields.setEnumFilterValues(fields, MyExample3203DTO_.customFieldDictionaryLevelTwo, CustomFieldDictionaryLevelTwoEnum.values());
        fields.enableFilter(MyExample3203DTO_.customFieldDictionaryLevelTwo);
        fields.setEnumFilterValues(
                fields,
                MyExample3203DTO_.customFieldDictionaryLevelTwo,
                CustomFieldDictionaryLevelTwoEnum.values()
        );
        fields.enableFilter(MyExample3203DTO_.customFieldDictionaryLevelTwo);
        fields.setEnumFilterValues(
                fields,
                MyExample3203DTO_.customFieldDictionaryLevelThree,
                CustomFieldDictionaryLevelThreeEnum.values()
        );
        fields.enableFilter(MyExample3203DTO_.customFieldDictionaryLevelThree);
        fields.setEnumFilterValues(fields, MyExample3203DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3203DTO_.customFieldDictionary);
        fields.enableSort(MyExample3203DTO_.customFieldDictionaryLevelTwo);
        fields.enableSort(MyExample3203DTO_.customFieldDictionary);
        fields.enableSort(MyExample3203DTO_.customFieldDictionaryLevelThree);
        fields.defaultGroupingHierarchy(
                MyExample3203DTO_.customFieldDictionary,
                MyExample3203DTO_.customFieldDictionaryLevelTwo,
                MyExample3203DTO_.customFieldDictionaryLevelThree,
                lvl -> lvl
                        .addWithCfg(
                                CustomFieldDictionaryEnum.LEVEL_1_HIGH,
                                cfg -> cfg.defaultExpanded(true),
                                lvl2 -> lvl2
                                        .addWithCfg(
                                                CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE,
                                                cfg -> cfg.defaultExpanded(true),
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
                                                        .addWithCfg(
                                                                CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE,
                                                                cfg -> cfg.defaultExpanded(true))
                                        )
                        )
        );

    }
}