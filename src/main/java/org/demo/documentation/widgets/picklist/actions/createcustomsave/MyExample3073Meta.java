package org.demo.documentation.widgets.picklist.actions.createcustomsave;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3073Meta extends FieldMetaBuilder<MyExample3073DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3073DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3073DTO_.customFieldId);
        fields.setEnabled(MyExample3073DTO_.customField);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3073DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3073DTO_.customField);

    }

}