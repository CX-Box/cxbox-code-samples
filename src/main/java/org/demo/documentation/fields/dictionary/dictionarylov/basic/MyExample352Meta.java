package org.demo.documentation.fields.dictionary.dictionarylov.basic;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.dictionary.dictionarylov.DictinaryLovRegion;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyExample352Meta extends FieldMetaBuilder<MyExample352DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample352DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample352DTO_.customField);
        fields.setDictionaryValues(MyExample352DTO_.customFieldLov);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample352DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setDictionaryFilterValues(MyExample352DTO_.customFieldLov);
    }

}