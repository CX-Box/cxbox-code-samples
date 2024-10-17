package org.demo.documentation.widgets.list.actions.edit.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3700Meta extends FieldMetaBuilder<MyExample3700DTO> {
    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3700DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3700DTO_.customFieldText);
        fields.setEnabled(MyExample3700DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3700DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3700DTO_.customFieldText);
        fields.enableFilter(MyExample3700DTO_.customField);
        fields.enableSort(MyExample3700DTO_.customField);
    }
    // --8<-- [end:buildIndependentMeta]
}