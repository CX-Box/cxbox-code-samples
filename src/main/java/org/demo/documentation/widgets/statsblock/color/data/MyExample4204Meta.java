package org.demo.documentation.widgets.statsblock.color.data;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample4204Meta extends FieldMetaBuilder<MyExample4204DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4204DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4204DTO_.customField);
        fields.setEnabled(MyExample4204DTO_.customFieldNum);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4204DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableSort(MyExample4204DTO_.customField);
    }

}