package org.demo.documentation.other.drilldown.option3.forsearch;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3431Meta extends FieldMetaBuilder<MyExample3431DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3431DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3431DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3431DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}