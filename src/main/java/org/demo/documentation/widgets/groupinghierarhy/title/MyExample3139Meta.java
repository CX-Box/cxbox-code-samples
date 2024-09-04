package org.demo.documentation.widgets.groupinghierarhy.title;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.demo.documentation.widgets.groupinghierarhy.title.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3139Meta extends FieldMetaBuilder<MyExample3139DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3139DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3139DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3139DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3139DTO_.customField);
        fields.setRequired(MyExample3139DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3139DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3139DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3139DTO_.customFieldDictionary);
    }

}