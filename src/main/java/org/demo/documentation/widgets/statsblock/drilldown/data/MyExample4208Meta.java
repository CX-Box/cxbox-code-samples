package org.demo.documentation.widgets.statsblock.drilldown.data;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4208Meta extends FieldMetaBuilder<MyExample4208DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4208DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4208DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4208DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample4208DTO_.customField);
    }

}