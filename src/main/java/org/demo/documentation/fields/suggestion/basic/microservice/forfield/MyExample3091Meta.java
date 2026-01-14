package org.demo.documentation.fields.suggestion.basic.microservice.forfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3091Meta extends FieldMetaBuilder<MyExample3091DTO> {

    @Override
    // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3091DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3091DTO_.customFieldNew);
        fields.setEnabled(MyExample3091DTO_.customField);

    }

    // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3091DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3091DTO_.customFieldNew);
    }

}