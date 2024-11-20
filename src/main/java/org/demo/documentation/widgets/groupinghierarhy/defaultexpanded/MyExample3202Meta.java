package org.demo.documentation.widgets.groupinghierarhy.defaultexpanded;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultexpanded.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3202Meta extends FieldMetaBuilder<MyExample3202DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3202DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3202DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3202DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3202DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumValues(MyExample3202DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3202DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3202DTO_.customFieldDictionary);
    }

}