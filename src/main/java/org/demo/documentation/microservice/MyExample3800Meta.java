package org.demo.documentation.microservice;

import org.cxbox.core.crudma.bc.impl.BcDescription;

import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3800Meta extends AnySourceFieldMetaBuilder<MyExample3800DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3800DTO> fields, BcDescription bc,
                                      String id, String parentId) {
        fields.setEnabled(MyExample3800DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3800DTO> fields, BcDescription bcDescription,
                                     String parentId) {
        fields.enableFilter(MyExample3800DTO_.customField);
    }

}