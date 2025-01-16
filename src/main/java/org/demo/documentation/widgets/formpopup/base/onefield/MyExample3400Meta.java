package org.demo.documentation.widgets.formpopup.base.onefield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3400Meta extends FieldMetaBuilder<MyExample3400DTO> {
    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3400DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3400DTO_.customFieldRequired);
        fields.setEnabled(MyExample3400DTO_.customFieldInlinePicklistId);
        fields.setEnabled(MyExample3400DTO_.customFieldInlinePicklist);
        fields.setEnabled(MyExample3400DTO_.customField2);
        fields.setEnabled(MyExample3400DTO_.customField);
        fields.setRequired(MyExample3400DTO_.customFieldRequired);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3400DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3400DTO_.customFieldRequired);
        fields.enableFilter(MyExample3400DTO_.customFieldInlinePicklist);
        fields.enableFilter(MyExample3400DTO_.customField2);
        fields.enableFilter(MyExample3400DTO_.customField);
    }
    // --8<-- [end:buildIndependentMeta]
}