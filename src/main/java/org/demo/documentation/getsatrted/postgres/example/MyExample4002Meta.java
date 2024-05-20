package org.demo.documentation.getsatrted.postgres.example;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4002Meta extends FieldMetaBuilder<MyExample4002DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4002DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4002DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4002DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample4002DTO_.customField);
    }

}