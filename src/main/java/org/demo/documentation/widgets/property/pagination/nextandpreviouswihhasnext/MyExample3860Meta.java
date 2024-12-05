package org.demo.documentation.widgets.property.pagination.nextandpreviouswihhasnext;


import org.cxbox.core.crudma.bc.impl.BcDescription;

import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3860Meta extends AnySourceFieldMetaBuilder<MyExample3860DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3860DTO> fields, BcDescription bcDescription, String id, String parentId) {
        fields.setEnabled(MyExample3860DTO_.customField);
        fields.setRequired(MyExample3860DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3860DTO> fields, BcDescription bcDescription, String parentId) {
        fields.enableSort(MyExample3860DTO_.customField);

    }
}