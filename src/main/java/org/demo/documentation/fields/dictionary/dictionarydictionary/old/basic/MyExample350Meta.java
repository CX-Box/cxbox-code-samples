package org.demo.documentation.fields.dictionary.dictionarydictionary.old.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.dictionary.dictionarydictionary.old.AdministeredDictionaryTypeOld.REGIONS;

@Service
public class MyExample350Meta extends FieldMetaBuilder<MyExample350DTO> {


    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample350DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample350DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample350DTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.setDictionaryTypeWithAllValues(MyExample350DTO_.customField, REGIONS);
    }
    // --8<-- [end:buildIndependentMeta]
}