package org.demo.documentation.fields.dictionary.dictionarydictionary.filtration;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample358Meta extends FieldMetaBuilder<MyExample358DTO> {


    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample358DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample358DTO_.customField);
        fields.setDictionaryValues(MyExample358DTO_.customFieldDictionary);

        fields.setEnabled(MyExample358DTO_.customFieldNewDictionary);
        fields.setDictionaryValues(MyExample358DTO_.customFieldNewDictionary);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample358DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample358DTO_.customFieldNewDictionary);
        fields.setDictionaryFilterValues(MyExample358DTO_.customFieldNewDictionary);

        fields.setDictionaryFilterValues(MyExample358DTO_.customFieldDictionary);
        fields.enableFilter(MyExample358DTO_.customFieldDictionary);

    }
    // --8<-- [end:buildIndependentMeta]
}