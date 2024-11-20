package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.onelevel.MyExample3164DTO_;
import org.springframework.stereotype.Service;

@Service
public class MyExample3203Meta extends FieldMetaBuilder<MyExample3203DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3203DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3203DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3203DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3203DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumValues(MyExample3203DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3203DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3203DTO_.customFieldDictionary);
        fields.defaultGroupingHierarchy(
                MyExample3203DTO_.customFieldDictionary,
                lvl -> lvl
                        .addWithCfg(
                                CustomFieldDictionaryEnum.HIGH,
                                cfg -> cfg.defaultExpanded(true))
        );
    }

}