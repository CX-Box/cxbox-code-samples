package org.demo.documentation.widgets.picklist.base.onefield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3079Meta extends FieldMetaBuilder<MyExample3079DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3079DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3079DTO_.customFieldInlinePickListId);
        fields.setEnabled(MyExample3079DTO_.customFieldInlinePickList);
        fields.setEnabled(MyExample3079DTO_.customFieldPickListId);
        fields.setEnabled(MyExample3079DTO_.customFieldPickList);
        fields.setEnabled(MyExample3079DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3079DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3079DTO_.customFieldInlinePickList);
        fields.enableFilter(MyExample3079DTO_.customFieldPickList);
    }

}