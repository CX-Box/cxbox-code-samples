package org.demo.documentation.feature.drilldown.simple;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3611Meta extends FieldMetaBuilder<MyExample3611DTO> {
    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3611DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3611DTO_.customFieldDrillDowm);
        fields.setEnabled(MyExample3611DTO_.customField);
        fields.setRequired(MyExample3611DTO_.customFieldDrillDowm);
        fields.setDrilldown(
                MyExample3611DTO_.customFieldDrillDowm,
                DrillDownType.INNER,
                "/screen/myexample3611/view/myexample3611list"
        );
    }
    // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3611DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3611DTO_.customFieldDrillDowm);
        fields.enableSort(MyExample3611DTO_.customFieldDrillDowm);
        fields.enableSort(MyExample3611DTO_.customField);
    }

}