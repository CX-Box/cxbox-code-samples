package org.demo.documentation.fields.suggestion.validationannotation.forfield;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3111Meta extends FieldMetaBuilder<MyExample3111DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3111DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3111DTO_.customField);
        fields.setPlaceholder(MyExample3111DTO_.customField, "Only letters");
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3111DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}