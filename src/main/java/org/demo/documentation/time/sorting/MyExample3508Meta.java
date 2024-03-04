package org.demo.documentation.time.sorting;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3508Meta extends FieldMetaBuilder<MyExample3508DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3508DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3508DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3508DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3508DTO_.customField);
    }

}