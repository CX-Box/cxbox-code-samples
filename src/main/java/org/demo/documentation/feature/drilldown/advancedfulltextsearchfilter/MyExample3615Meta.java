package org.demo.documentation.feature.drilldown.advancedfulltextsearchfilter;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.drilldown.advancedonebcfilter.CxboxMyExample3612Controller;
import org.demo.documentation.feature.drilldown.advancedonebcfilter.MyExample3612DTO_;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

@Service
public class MyExample3615Meta extends FieldMetaBuilder<MyExample3615DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3615DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3615DTO_.address);
        fields.setEnabled(MyExample3615DTO_.fullName);
        fields.setEnabled(MyExample3615DTO_.customField);
        // --8<-- [start:urlBC]
        String urlBC = "/screen/myexample3615/view/myexample3615list" + "/" + CxboxMyExample3615Controller.myexample3615;
        // --8<-- [end:urlBC]
        // --8<-- [start:urlFilter]
        String urlFilterForField = URLEncoder.encode("fullTextSearch=Moscow%2C+Dmitrov");
        String urlFilter = "?filters={\""
                + CxboxMyExample3615Controller.myexample3615
                + "\":\""
                + "_"
                + urlFilterForField
                + "\"}";
        // --8<-- [end:urlFilter]
        // --8<-- [start:url]
        fields.setDrilldown(
                MyExample3615DTO_.customField,
                DrillDownType.INNER,
                urlBC + urlFilter
        );
        // --8<-- [end:url]
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3615DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3615DTO_.address);
        fields.enableSort(MyExample3615DTO_.address);
        fields.enableFilter(MyExample3615DTO_.fullName);
        fields.enableSort(MyExample3615DTO_.fullName);

    }

}