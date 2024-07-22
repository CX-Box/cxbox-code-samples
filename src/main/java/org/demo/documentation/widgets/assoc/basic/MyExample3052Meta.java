package org.demo.documentation.widgets.assoc.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3052Meta extends FieldMetaBuilder<MyExample3052DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3052DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3052DTO_.customFieldMulti);
        fields.setEnabled(MyExample3052DTO_.customField);
        fields.setRequired(MyExample3052DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3052DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3052DTO_.customFieldMulti);
    }

}