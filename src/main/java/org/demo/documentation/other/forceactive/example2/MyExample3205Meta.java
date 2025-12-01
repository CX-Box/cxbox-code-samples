package org.demo.documentation.other.forceactive.example2;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3205Meta extends FieldMetaBuilder<MyExample3205DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3205DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3205DTO_.customFieldCheckBox);
        fields.setEnabled(MyExample3205DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3205DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3205DTO_.customFieldCheckBox);
        fields.setForceActive(MyExample3205DTO_.customFieldCheckBox);
    }

}