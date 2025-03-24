package org.demo.documentation.fields.suggestion.basic.listvalues.forsuggectionpicklistfield;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample4600Meta extends AnySourceFieldMetaBuilder<MyExample4600DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4600DTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4600DTO> fields, BcDescription bcDescription, String parentId) {
    }

}
