package org.demo.documentation.time.filtration;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3504Meta extends FieldMetaBuilder<MyExample3504DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3504DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3504DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3504DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3504DTO_.customField);
    }

}