package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3862Meta extends FieldMetaBuilder<MyExample3862DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3862DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3862DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3862DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}