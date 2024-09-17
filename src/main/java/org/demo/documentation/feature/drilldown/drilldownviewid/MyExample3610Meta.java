package org.demo.documentation.feature.drilldown.drilldownviewid;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3610Meta extends FieldMetaBuilder<MyExample3610DTO> {
    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3610DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3610DTO_.customFieldDrillDown);
        fields.setEnabled(MyExample3610DTO_.customField);
        fields.setRequired(MyExample3610DTO_.customFieldDrillDown);
        fields.setDrilldown(
                MyExample3610DTO_.customFieldDrillDown,
                DrillDownType.INNER,
                "/screen/myexample3610/view/myexample3610form/" + CxboxMyExample3610Controller.myexample3610 + "/" + id
        );

    }
    // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3610DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3610DTO_.customFieldDrillDown);
        fields.enableSort(MyExample3610DTO_.customFieldDrillDown);
    }

}