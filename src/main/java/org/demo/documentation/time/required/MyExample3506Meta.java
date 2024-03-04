package org.demo.documentation.time.required;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3506Meta extends FieldMetaBuilder<MyExample3506DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3506DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3506DTO_.customField);
        fields.setRequired(MyExample3506DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3506DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3506DTO_.customField);
    }

}