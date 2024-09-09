package org.demo.documentation.navigation.tab.other.example2;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3422Meta extends FieldMetaBuilder<MyExample3422DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3422DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3422DTO_.customFieldDrilldown);
        fields.setEnabled(MyExample3422DTO_.customField);
        fields.setRequired(MyExample3422DTO_.customField);
        fields.setDrilldown(
                MyExample3422DTO_.customFieldDrilldown,
                DrillDownType.INNER,
                "/screen/myexample3422/view/taskInfo/" + CxboxMyExample3422Controller.myexample3422 + "/" + id
        );
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3422DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3422DTO_.customFieldDrilldown);
    }

}