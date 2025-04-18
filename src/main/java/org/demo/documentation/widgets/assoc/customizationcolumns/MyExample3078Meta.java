package org.demo.documentation.widgets.assoc.customizationcolumns;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3078Meta extends FieldMetaBuilder<MyExample3078DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3078DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3078DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample3078DTO_.customFieldNumber);
        fields.setEnabled(MyExample3078DTO_.customFieldTest);
        fields.setEnabled(MyExample3078DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3078DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3078DTO_.customFieldMultivalue);
        fields.enableFilter(MyExample3078DTO_.customFieldNumber);
        fields.enableFilter(MyExample3078DTO_.customFieldTest);
    }

}