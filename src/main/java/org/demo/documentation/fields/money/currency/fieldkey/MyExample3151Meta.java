package org.demo.documentation.fields.money.currency.fieldkey;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3151Meta extends FieldMetaBuilder<MyExample3151DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3151DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3151DTO_.customField);
        fields.setEnabled(MyExample3151DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3151DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3151DTO_.customField);
    }

}