package org.demo.documentation.widgets.statsblock.showcondition.data;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample4229Meta extends FieldMetaBuilder<MyExample4229DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4229DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4229DTO_.customField);
        fields.setRequired(MyExample4229DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4229DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableSort(MyExample4229DTO_.customField);
    }

}
