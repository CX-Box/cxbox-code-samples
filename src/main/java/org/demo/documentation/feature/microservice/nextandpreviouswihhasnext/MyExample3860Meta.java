package org.demo.documentation.feature.microservice.nextandpreviouswihhasnext;


import org.cxbox.core.crudma.bc.impl.BcDescription;

import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3860Meta extends AnySourceFieldMetaBuilder<MyExample3860DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3860DTO> fields, BcDescription bcDescription, String id, String parentId) {
        fields.setEnabled(MyExample3860DTO_.customField);
        fields.setRequired(MyExample3860DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3860DTO> fields, BcDescription bcDescription, String parentId) {

    }
}