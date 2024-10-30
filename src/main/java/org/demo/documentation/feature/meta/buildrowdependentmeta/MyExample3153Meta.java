package org.demo.documentation.feature.meta.buildrowdependentmeta;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3153Meta extends FieldMetaBuilder<MyExample3153DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3153DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3153DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3153DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}