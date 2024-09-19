package org.demo.documentation.widgets.picklist.title.withtitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3068Meta extends FieldMetaBuilder<MyExample3068DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3068DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3068DTO_.customFieldId);
        fields.setEnabled(MyExample3068DTO_.customField);
        fields.setEnabled(MyExample3068DTO_.customFieldId);
        fields.setEnabled(MyExample3068DTO_.customField);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3068DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3068DTO_.customField);
        fields.enableSort(MyExample3068DTO_.customField);
        fields.enableSort(MyExample3068DTO_.customFieldId);
    }

}