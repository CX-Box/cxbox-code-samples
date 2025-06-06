package org.demo.documentation.widgets.property.pagination.hidelimitoptions.list;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3865Meta extends FieldMetaBuilder<MyExample3865DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3865DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3865DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample3865DTO_.customFieldPickListId);
        fields.setEnabled(MyExample3865DTO_.customFieldPickList);
        fields.setEnabled(MyExample3865DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3865DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3865DTO_.customFieldMultivalue);
        fields.enableFilter(MyExample3865DTO_.customFieldPickList);
    }

}