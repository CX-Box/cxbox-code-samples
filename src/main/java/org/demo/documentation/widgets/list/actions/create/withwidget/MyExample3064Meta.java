package org.demo.documentation.widgets.list.actions.create.withwidget;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3064Meta extends FieldMetaBuilder<MyExample3064DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3064DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3064DTO_.customFieldText);
        fields.setEnabled(MyExample3064DTO_.customField);
        fields.setRequired(MyExample3064DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3064DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3064DTO_.customFieldText);
    }

}