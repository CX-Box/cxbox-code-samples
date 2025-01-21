package org.demo.documentation.fields.suggestion.validationdynamic.forfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3118Meta extends FieldMetaBuilder<MyExample3118DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3118DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3118DTO_.customField);
        fields.setEnabled(MyExample3118DTO_.customFieldAdditional);
        fields.setPlaceholder(MyExample3118DTO_.customField, "Only letters");
        fields.setPlaceholder(MyExample3118DTO_.customFieldAdditional, "Only letters");
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3118DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}