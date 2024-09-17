package org.demo.documentation.feature.drilldown.goingforwardafterdrilldown;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.feature.drilldown.goingbackafterdrilldown.CxboxMyExample3620Controller;
import org.demo.documentation.feature.drilldown.goingbackafterdrilldown.MyExample3620DTO_;
import org.springframework.stereotype.Service;

@Service
public class MyExample3621Meta extends FieldMetaBuilder<MyExample3621DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3621DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3621DTO_.customField);
        fields.setRequired(MyExample3621DTO_.customField);
        fields.setDrilldown(
                MyExample3621DTO_.customField,
                DrillDownType.INNER,
                "/screen/myexample3621/view/myexample3621info/" + CxboxMyExample3621Controller.myexample3621 + "/" + id
        );
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3621DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableSort(MyExample3621DTO_.customField);
    }

}