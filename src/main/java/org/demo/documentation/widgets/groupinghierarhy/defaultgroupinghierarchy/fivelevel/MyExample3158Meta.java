package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fivelevel;

import org.cxbox.api.data.dto.hierarhy.grouping.Hierarchy;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fivelevel.enums.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyExample3158Meta extends FieldMetaBuilder<MyExample3158DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3158DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3158DTO_.customFieldDictionaryLevelFive, CustomFieldDictionaryLevelFiveEnum.values());
        fields.setEnabled(MyExample3158DTO_.customFieldDictionaryLevelFive);
        fields.setEnumValues(MyExample3158DTO_.customFieldDictionaryLevelFour, CustomFieldDictionaryLevelFourEnum.values());
        fields.setEnabled(MyExample3158DTO_.customFieldDictionaryLevelFour);
        fields.setEnumValues(
                MyExample3158DTO_.customFieldDictionaryLevelThree,
                CustomFieldDictionaryLevelThreeEnum.values()
        );
        fields.setEnabled(MyExample3158DTO_.customFieldDictionaryLevelThree);
        fields.setEnumValues(MyExample3158DTO_.customFieldDictionaryLevelTwo, CustomFieldDictionaryLevelTwoEnum.values());
        fields.setEnabled(MyExample3158DTO_.customFieldDictionaryLevelTwo);
        fields.setEnumValues(MyExample3158DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3158DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3158DTO_.customField);
    }

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3158DTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.setEnumFilterValues(
                fields,
                MyExample3158DTO_.customFieldDictionaryLevelFive,
                CustomFieldDictionaryLevelFiveEnum.values()
        );
        fields.enableFilter(MyExample3158DTO_.customFieldDictionaryLevelFive);
        fields.setEnumFilterValues(
                fields,
                MyExample3158DTO_.customFieldDictionaryLevelFour,
                CustomFieldDictionaryLevelFourEnum.values()
        );
        fields.enableFilter(MyExample3158DTO_.customFieldDictionaryLevelFour);
        fields.setEnumFilterValues(
                fields,
                MyExample3158DTO_.customFieldDictionaryLevelThree,
                CustomFieldDictionaryLevelThreeEnum.values()
        );
        fields.enableFilter(MyExample3158DTO_.customFieldDictionaryLevelThree);
        fields.setEnumFilterValues(
                fields,
                MyExample3158DTO_.customFieldDictionaryLevelTwo,
                CustomFieldDictionaryLevelTwoEnum.values()
        );
        fields.enableFilter(MyExample3158DTO_.customFieldDictionaryLevelTwo);
        fields.setEnumFilterValues(fields, MyExample3158DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3158DTO_.customFieldDictionary);
        fields.enableSort(MyExample3158DTO_.customFieldDictionaryLevelTwo);

        fields.defaultGroupingHierarchy(
                List.of(
                        MyExample3158DTO_.customFieldDictionary,
                        MyExample3158DTO_.customFieldDictionaryLevelTwo,
                        MyExample3158DTO_.customFieldDictionaryLevelThree,
                        MyExample3158DTO_.customFieldDictionaryLevelFour,
                        MyExample3158DTO_.customFieldDictionaryLevelFive
                ),
                new Hierarchy<Object, Hierarchy<Object, Hierarchy<Object, Hierarchy<Object, Hierarchy<Object, ?>>>>>()
                        .add(
                                CustomFieldDictionaryEnum.LEVEL_1_HIGH,
                                lvl2 -> lvl2.add(
                                        CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE,
                                        lvl3 -> lvl3.add(
                                                CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE,
                                                lvl4 -> lvl4.add(
                                                        CustomFieldDictionaryLevelFourEnum.LEVEL_4_MIDDLE,
                                                        lvl5 -> lvl5.add(
                                                                CustomFieldDictionaryLevelFiveEnum.LEVEL_5_HIGH)))
                                )
                        )
                        .add(
                                CustomFieldDictionaryEnum.LEVEL_1_MIDDLE,
                                lvl2 -> lvl2.add(
                                        CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE,
                                        lvl3 -> lvl3.add(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE)
                                )
                        )
        );
    }
    // --8<-- [end:buildIndependentMeta]
}