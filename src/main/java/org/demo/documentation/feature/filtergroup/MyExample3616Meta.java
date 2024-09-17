package org.demo.documentation.feature.filtergroup;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3616Meta extends FieldMetaBuilder<MyExample3616DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3616DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3616DTO_.customFieldNew);
        fields.setEnabled(MyExample3616DTO_.customField);
        fields.setRequired(MyExample3616DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3616DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3616DTO_.customFieldNew);
        fields.enableSort(MyExample3616DTO_.customFieldNew);
        fields.enableFilter(MyExample3616DTO_.customField);
        fields.enableSort(MyExample3616DTO_.customField);
    }

}