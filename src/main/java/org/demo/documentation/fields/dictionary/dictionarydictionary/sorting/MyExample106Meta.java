package org.demo.documentation.fields.dictionary.dictionarydictionary.sorting;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.dictionary.dictionarydictionary.basic.MyExample352DTO_;
import org.springframework.stereotype.Service;

@Service
public class MyExample106Meta extends FieldMetaBuilder<MyExample106DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample106DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample106DTO_.customField);

        fields.setEnabled(MyExample106DTO_.customFieldDictionary);
        fields.setDictionaryValues(MyExample106DTO_.customFieldDictionary);

        fields.setEnabled(MyExample106DTO_.customFieldDictionaryExample);
        fields.setDictionaryValues(MyExample106DTO_.customFieldDictionaryExample);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample106DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableSort(MyExample106DTO_.customFieldDictionary);
        fields.enableSort(MyExample106DTO_.customFieldDictionaryExample);
        fields.setDictionaryFilterValues(MyExample106DTO_.customFieldDictionary);
        fields.setDictionaryFilterValues(MyExample106DTO_.customFieldDictionaryExample);
    }

}