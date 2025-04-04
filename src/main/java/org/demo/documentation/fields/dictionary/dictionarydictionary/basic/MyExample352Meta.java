package org.demo.documentation.fields.dictionary.dictionarydictionary.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample352Meta extends FieldMetaBuilder<MyExample352DTO> {


    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample352DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample352DTO_.customField);
        fields.setEnabled(MyExample352DTO_.customFieldDictionary);
        fields.setDictionaryValues(MyExample352DTO_.customFieldDictionary);
    }
    // --8<-- [end:buildRowDependentMeta]


    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample352DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setDictionaryFilterValues(MyExample352DTO_.customFieldDictionary);
    }
    // --8<-- [end:buildIndependentMeta]
}