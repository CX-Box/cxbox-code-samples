package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fivelevel;

import org.cxbox.api.data.dto.hierarhy.grouping.Hierarchy;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fivelevel.enums.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MyExample3158Meta extends FieldMetaBuilder<MyExample3158DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3158DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3158DTO_.customFieldDictionaryLevelFive, CustomFieldDictionaryLevelFiveEnum.values());
        fields.setEnabled(MyExample3158DTO_.customFieldDictionaryLevelFive);
        fields.setEnumValues(MyExample3158DTO_.customFieldDictionaryLevelFour, CustomFieldDictionaryLevelFourEnum.values());
        fields.setEnabled(MyExample3158DTO_.customFieldDictionaryLevelFour);
        fields.setEnumValues(MyExample3158DTO_.customFieldDictionaryLevelThree, CustomFieldDictionaryLevelThreeEnum.values());
        fields.setEnabled(MyExample3158DTO_.customFieldDictionaryLevelThree);
        fields.setEnumValues(MyExample3158DTO_.customFieldDictionaryLevelTwo, CustomFieldDictionaryLevelTwoEnum.values());
        fields.setEnabled(MyExample3158DTO_.customFieldDictionaryLevelTwo);
        fields.setEnumValues(MyExample3158DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3158DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3158DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3158DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3158DTO_.customFieldDictionaryLevelFive, CustomFieldDictionaryLevelFiveEnum.values());
        fields.enableFilter(MyExample3158DTO_.customFieldDictionaryLevelFive);
        fields.setEnumFilterValues(fields, MyExample3158DTO_.customFieldDictionaryLevelFour, CustomFieldDictionaryLevelFourEnum.values());
        fields.enableFilter(MyExample3158DTO_.customFieldDictionaryLevelFour);
        fields.setEnumFilterValues(fields, MyExample3158DTO_.customFieldDictionaryLevelThree, CustomFieldDictionaryLevelThreeEnum.values());
        fields.enableFilter(MyExample3158DTO_.customFieldDictionaryLevelThree);
        fields.setEnumFilterValues(fields, MyExample3158DTO_.customFieldDictionaryLevelTwo, CustomFieldDictionaryLevelTwoEnum.values());
        fields.enableFilter(MyExample3158DTO_.customFieldDictionaryLevelTwo);
        fields.setEnumFilterValues(fields, MyExample3158DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3158DTO_.customFieldDictionary);
        fields.enableSort(MyExample3158DTO_.customFieldDictionaryLevelTwo);
       /* Hierarchy  hierarchy =  new Hierarchy<>();
        Hierarchy  hierarchy2 =  new Hierarchy<>();
        hierarchy.add((Object) CustomFieldDictionaryEnum.LEVEL_1_HIGH,
                hierarchy2.add(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE));




        fields.defaultGroupingHierarchy(
                List.of(MyExample3158DTO_.customFieldDictionary,
                        MyExample3158DTO_.customFieldDictionaryLevelTwo,
                        MyExample3158DTO_.customFieldDictionaryLevelThree,
                        MyExample3158DTO_.customFieldDictionaryLevelFour,
                        MyExample3158DTO_.customFieldDictionaryLevelFive), (Hierarchy<?, ?>) levels);*/
    }

}