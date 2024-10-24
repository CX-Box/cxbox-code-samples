package org.demo.documentation.widgets.picklist.actions.create;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3072Meta extends FieldMetaBuilder<MyExample3072DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3072DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3072DTO_.customFieldInlinePicklistId);
        fields.setEnabled(MyExample3072DTO_.customFieldInlinePicklist);
        fields.setEnabled(MyExample3072DTO_.customFieldId);
        fields.setEnabled(MyExample3072DTO_.customField);

    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3072DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3072DTO_.customFieldInlinePicklist);
        fields.enableFilter(MyExample3072DTO_.customField);
        fields.enableSort(MyExample3072DTO_.customFieldInlinePicklist);
        fields.enableSort(MyExample3072DTO_.customField);
    }

}