package org.demo.documentation.widgets.picklist.base.allfields.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3067PickInlinePicklistPickMeta extends FieldMetaBuilder<MyEntity3067PickInlinePicklistPickDTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3067PickInlinePicklistPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3067PickInlinePicklistPickDTO_.id);
        fields.setEnabled(MyEntity3067PickInlinePicklistPickDTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3067PickInlinePicklistPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
