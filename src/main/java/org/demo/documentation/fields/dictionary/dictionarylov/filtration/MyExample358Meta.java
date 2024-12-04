package org.demo.documentation.fields.dictionary.dictionarylov.filtration;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample358Meta extends FieldMetaBuilder<MyExample358DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample358DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample358DTO_.customField);
        fields.setDictionaryValues(MyExample358DTO_.customFieldDictionary);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample358DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setDictionaryFilterValues(MyExample358DTO_.customFieldDictionary);
    }

}