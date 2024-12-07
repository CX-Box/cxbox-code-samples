package org.demo.documentation.fields.dictionary.dictionarydictionary.icon;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample355Meta extends FieldMetaBuilder<MyExample355DTO> {

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample355DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample355DTO_.customField);
        fields.setEnabled(MyExample355DTO_.customFieldDictionary);
        fields.setDictionaryValues(MyExample355DTO_.customFieldDictionary);

    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample355DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setDictionaryFilterValues(MyExample355DTO_.customFieldDictionary);
        fields.setDictionaryIcons(MyExample355DTO_.customFieldDictionary,CustomDictionary.icons);
    }
    // --8<-- [end:buildIndependentMeta]
}