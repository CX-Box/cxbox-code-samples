package org.demo.documentation.widgets.statsblock.icon.withouticon;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4224Meta extends AnySourceFieldMetaBuilder<MyExample4224DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4224DTO> fields, BcDescription bc,
                                      String id, String parentId) {
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4224DTO> fields, BcDescription bc, String parentId) {
    }

}