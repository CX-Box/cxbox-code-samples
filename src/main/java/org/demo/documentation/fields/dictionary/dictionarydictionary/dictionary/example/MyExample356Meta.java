package org.demo.documentation.fields.dictionary.dictionarydictionary.dictionary.example;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample356Meta extends FieldMetaBuilder<MyExample356DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample356DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample356DTO_.customField);
        fields.setEnabled(MyExample356DTO_.customFieldDictionary);
        fields.setDictionaryValues(MyExample356DTO_.customFieldDictionary);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample356DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setDictionaryFilterValues(MyExample356DTO_.customFieldDictionary);
    }

}