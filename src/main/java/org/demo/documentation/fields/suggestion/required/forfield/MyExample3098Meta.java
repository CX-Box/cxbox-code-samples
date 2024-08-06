package org.demo.documentation.fields.suggestion.required.forfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3098Meta extends FieldMetaBuilder<MyExample3098DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3098DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3098DTO_.customField);
        fields.setRequired(MyExample3098DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3098DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}