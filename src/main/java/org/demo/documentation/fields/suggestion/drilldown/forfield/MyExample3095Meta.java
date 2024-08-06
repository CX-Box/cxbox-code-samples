package org.demo.documentation.fields.suggestion.drilldown.forfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.radio.drilldown.MyExample24DTO_;
import org.demo.documentation.fields.radio.drilldown.PlatformMyExample24Controller;
import org.springframework.stereotype.Service;

@Service
public class MyExample3095Meta extends FieldMetaBuilder<MyExample3095DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3095DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3095DTO_.customField);
        fields.setDrilldown(
                MyExample3095DTO_.customField,
                DrillDownType.INNER,
                "/screen/myexample3080/view/myexample3091form/"
        );
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3095DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}