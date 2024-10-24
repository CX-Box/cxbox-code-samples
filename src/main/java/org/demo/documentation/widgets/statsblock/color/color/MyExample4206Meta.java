package org.demo.documentation.widgets.statsblock.color.color;

import org.cxbox.core.crudma.bc.impl.BcDescription;

import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample4206Meta extends AnySourceFieldMetaBuilder<MyExample4206DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4206DTO> fields, BcDescription bc,
                                      String id, String parentId) {
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4206DTO> fields, BcDescription bc, String parentId) {
    }

}