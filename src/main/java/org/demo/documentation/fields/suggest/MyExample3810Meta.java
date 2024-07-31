package org.demo.documentation.fields.suggest;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3810Meta extends AnySourceFieldMetaBuilder<MyExample3810DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3810DTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3810DTO> fields, BcDescription bcDescription, String parentId) {
    }

}
