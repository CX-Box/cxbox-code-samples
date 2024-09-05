package org.demo.documentation.widgets.list.actions.edit.withwidget;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3065Meta extends FieldMetaBuilder<MyExample3065DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3065DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3065DTO_.customFieldText);
        fields.setEnabled(MyExample3065DTO_.customField);
        fields.setRequired(MyExample3065DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3065DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3065DTO_.customFieldText);
    }

}