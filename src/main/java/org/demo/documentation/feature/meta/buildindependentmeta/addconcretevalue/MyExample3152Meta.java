package org.demo.documentation.feature.meta.buildindependentmeta.addconcretevalue;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.meta.buildindependentmeta.addconcretevalue.MyExample3152DTO_;
import org.demo.documentation.feature.meta.buildindependentmeta.addconcretevalue.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3152Meta extends FieldMetaBuilder<MyExample3152DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3152DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3152DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3152DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3152DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3152DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3152DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3152DTO_.customFieldDictionary);

        SimpleDictionary myValue = new SimpleDictionary("CUSTOM_KEY", "Custom value");
        fields.addConcreteValue(MyExample3152DTO_.customFieldDictionary, myValue);
        fields.addConcreteFilterValue(MyExample3152DTO_.customFieldDictionary, myValue);

    }

}