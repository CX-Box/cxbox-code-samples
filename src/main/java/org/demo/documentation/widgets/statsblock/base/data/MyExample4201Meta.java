package org.demo.documentation.widgets.statsblock.base.data;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample4201Meta extends FieldMetaBuilder<MyExample4201DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4201DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4201DTO_.customField);
        fields.setEnabled(MyExample4201DTO_.customFieldNum);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4201DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}