package org.demo.documentation.widgets.picklist.base.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3067Meta extends FieldMetaBuilder<MyExample3067DTO> {

    @Override
    // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3067DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3067DTO_.customFieldInlinePickListId);
        fields.setEnabled(MyExample3067DTO_.customFieldInlinePickList);
        fields.setEnabled(MyExample3067DTO_.customFieldId);
        fields.setEnabled(MyExample3067DTO_.customField);

    }

    // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3067DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3067DTO_.customFieldInlinePickList);
        fields.enableFilter(MyExample3067DTO_.customField);
        fields.enableSort(MyExample3067DTO_.customFieldId);
        fields.enableSort(MyExample3067DTO_.customField);
    }

}