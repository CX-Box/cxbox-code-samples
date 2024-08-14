package org.demo.documentation.feature.drilldown.byview;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3055Meta extends FieldMetaBuilder<MyExample3055DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3055DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setDrilldown(
                MyExample3055DTO_.customField,
                DrillDownType.INNER,
                "/screen/myexample32352/view/myexample3235thirdleveltab21/myexample3235"
        );
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3055DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}