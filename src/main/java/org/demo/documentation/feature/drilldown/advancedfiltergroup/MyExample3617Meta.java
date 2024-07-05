package org.demo.documentation.feature.drilldown.advancedfiltergroup;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.feature.drilldown.advancedfulltextsearchfilter.CxboxMyExample3615Controller;
import org.demo.documentation.feature.drilldown.advancedfulltextsearchfilter.MyExample3615DTO_;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

@Service
public class MyExample3617Meta extends FieldMetaBuilder<MyExample3617DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3617DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3617DTO_.customFieldDrillDown);
        fields.setEnabled(MyExample3617DTO_.customFieldNew);
        fields.setEnabled(MyExample3617DTO_.customField);
        fields.setRequired(MyExample3617DTO_.customField);
        // --8<-- [start:urlBC]
        String urlBC = "/screen/myexample3617/view/myexample3617list" + "/" + CxboxMyExample3617Controller.myexample3617;
        // --8<-- [end:urlBC]
        // --8<-- [start:urlFilter]
        String urlFilterForField = URLEncoder.encode("customField.contains=2&customFieldNew.contains=test");
        String urlFilter = "?filters={\""
                + CxboxMyExample3617Controller.myexample3617
                + "\":\""
                + "_"
                + urlFilterForField
                + "\"}";
        // --8<-- [end:urlFilter]
        // --8<-- [start:url]
        fields.setDrilldown(
                MyExample3617DTO_.customFieldDrillDown,
                DrillDownType.INNER,
                urlBC + urlFilter
        );
        // --8<-- [end:url]

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3617DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3617DTO_.customFieldDrillDown);
        fields.enableFilter(MyExample3617DTO_.customFieldNew);
    }

}