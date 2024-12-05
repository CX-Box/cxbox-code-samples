package org.demo.documentation.feature.administration.dictionary;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample357Meta extends FieldMetaBuilder<DictionaryItemDTO> {

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<DictionaryItemDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(DictionaryItemDTO_.active);
        fields.setEnabled(DictionaryItemDTO_.description);
        fields.setEnabled(DictionaryItemDTO_.displayOrder);
        fields.setEnabled(DictionaryItemDTO_.value);
        fields.setEnabled(DictionaryItemDTO_.key);
        fields.setEnabled(DictionaryItemDTO_.type);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<DictionaryItemDTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(DictionaryItemDTO_.active);
        fields.enableFilter(DictionaryItemDTO_.description);
        fields.enableFilter(DictionaryItemDTO_.displayOrder);
        fields.enableFilter(DictionaryItemDTO_.value);
        fields.enableFilter(DictionaryItemDTO_.key);
        fields.enableFilter(DictionaryItemDTO_.type);
    }
    // --8<-- [end:buildIndependentMeta]
}