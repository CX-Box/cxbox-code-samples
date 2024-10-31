package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel;

import org.cxbox.api.data.dto.hierarhy.grouping.Level;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.onelevel.MyExample3155DTO_;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.MyExample3165DTO_;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel.enums.CustomFieldDictionaryLevelTwoEnum;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3157DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3157DTO_.customFieldDictionaryLevelTwo, CustomFieldDictionaryLevelTwoEnum.values());
        fields.enableFilter(MyExample3157DTO_.customFieldDictionaryLevelTwo);
        fields.setEnumFilterValues(fields, MyExample3157DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3157DTO_.customFieldDictionary);

        fields.defaultGroupingHierarchy(
                MyExample3157DTO_.customFieldDictionary,
                MyExample3157DTO_.customFieldDictionaryLevelTwo,
                Set.of(
                        Level.builder(
                                CustomFieldDictionaryEnum.LEVEL_1_HIGH,
                                Set.of(
                                        Level.builder(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE).build()
                                )).build(),
                        Level.builder(
                                CustomFieldDictionaryEnum.LEVEL_1_MIDDLE,
                                Set.of(
                                        Level.builder(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_HIGH).build()
                                )
                        ).build(),
                        Level.builder(
                                        CustomFieldDictionaryEnum.LEVEL_1_MIDDLE,
                                        new HashSet<Level<CustomFieldDictionaryLevelTwoEnum, ?>>()
                                )
                                .build()
                )
        );

    }

}