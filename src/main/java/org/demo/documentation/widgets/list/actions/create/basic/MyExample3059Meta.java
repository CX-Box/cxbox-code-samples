package org.demo.documentation.widgets.list.actions.create.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3059Meta extends FieldMetaBuilder<MyExample3059DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3059DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3059DTO_.customFieldText);
        fields.setEnabled(MyExample3059DTO_.customField);
        fields.setRequired(MyExample3059DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3059DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3059DTO_.customFieldText);
    }

}