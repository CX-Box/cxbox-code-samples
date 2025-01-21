package org.demo.documentation.widgets.picklist.customizationcolumns;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3089Meta extends FieldMetaBuilder<MyExample3089DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3089DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3089DTO_.customFieldPicklistId);
        fields.setEnabled(MyExample3089DTO_.customFieldPicklist);
        fields.setEnabled(MyExample3089DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3089DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3089DTO_.customFieldPicklist);
    }

}