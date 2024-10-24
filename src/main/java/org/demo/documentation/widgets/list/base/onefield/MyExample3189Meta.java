package org.demo.documentation.widgets.list.base.onefield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3189Meta extends FieldMetaBuilder<MyExample3189DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3189DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3189DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3189DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}