package org.demo.documentation.feature.drilldown.goingbackafterdrilldown;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3620Meta extends FieldMetaBuilder<MyExample3620DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3620DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3620DTO_.customField);
        fields.setRequired(MyExample3620DTO_.customField);
        fields.setDrilldown(
                MyExample3620DTO_.customField,
                DrillDownType.INNER,
                "/screen/myexample3620/view/myexample3620info/" + CxboxMyExample3620Controller.myexample3620 + "/" + id
        );
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3620DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableSort(MyExample3620DTO_.customField);
    }

}