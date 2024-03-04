package org.demo.documentation.time.base;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3500Meta extends FieldMetaBuilder<MyExample3500DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3500DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3500DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3500DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3500DTO_.customField);
    }

}