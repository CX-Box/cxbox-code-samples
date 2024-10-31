package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.onelevel;

import org.cxbox.api.data.dto.hierarhy.grouping.Level;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.onelevel.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MyExample3164Meta extends FieldMetaBuilder<MyExample3164DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3164DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3164DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3164DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3164DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3164DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3164DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3164DTO_.customFieldDictionary);
        fields.defaultGroupingHierarchy(
                MyExample3164DTO_.customFieldDictionary,
                Set.of(
                        Level.builder(CustomFieldDictionaryEnum.LEVEL_1_HIGH).build(),
                        Level.builder(CustomFieldDictionaryEnum.LEVEL_1_MIDDLE).build()
                ));
    }

}