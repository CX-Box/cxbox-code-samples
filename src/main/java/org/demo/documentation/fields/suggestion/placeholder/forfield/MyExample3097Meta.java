package org.demo.documentation.fields.suggestion.placeholder.forfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3097Meta extends FieldMetaBuilder<MyExample3097DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3097DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3097DTO_.customField);
        fields.setPlaceholder(MyExample3097DTO_.customField,"Placeholder text");
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3097DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}