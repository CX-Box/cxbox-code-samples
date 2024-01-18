package org.demo.documentation.widgets.formpopup.base;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3400Meta extends FieldMetaBuilder<MyExample3400DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3400DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3400DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3400DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3400DTO_.customField);
    }

}