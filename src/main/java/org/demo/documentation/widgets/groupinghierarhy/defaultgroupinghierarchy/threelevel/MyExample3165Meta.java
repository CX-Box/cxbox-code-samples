package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3165Meta extends FieldMetaBuilder<MyExample3165DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3165DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3165DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3165DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3165DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3165DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3165DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3165DTO_.customFieldDictionary);
    }

}