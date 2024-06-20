package org.demo.documentation.widgets.statsblock.icon.withicon;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4223Meta extends AnySourceFieldMetaBuilder<MyExample4223DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4223DTO> fields, BcDescription bc,
                                      String id, String parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4223DTO> fields, BcDescription bc, String parentId) {
    }

}