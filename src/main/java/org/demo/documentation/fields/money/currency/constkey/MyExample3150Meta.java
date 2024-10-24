package org.demo.documentation.fields.money.currency.constkey;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.money.currency.constkey.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3150Meta extends FieldMetaBuilder<MyExample3150DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3150DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3150DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3150DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3150DTO_.customField);
        fields.setEnabled(MyExample3150DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3150DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3150DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3150DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3150DTO_.customField);
        fields.enableSort(MyExample3150DTO_.customField);
    }

}