package org.demo.documentation.widgets.statsblock.base.customfields;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4200Meta extends AnySourceFieldMetaBuilder<MyExample4200DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4200DTO> fields, BcDescription bc,
                                      String id, String parentId)  {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4200DTO> fields,  BcDescription bc, String parentId) {
    }

}