package org.demo.documentation.getstarted.microservice.example;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4001Meta extends AnySourceFieldMetaBuilder<MyExample4001DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4001DTO> fields, BcDescription bc,
                                      String id, String parentId) {
        fields.setEnabled(MyExample4001DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4001DTO> fields, BcDescription bcDescription,
                                     String parentId) {
    }

}