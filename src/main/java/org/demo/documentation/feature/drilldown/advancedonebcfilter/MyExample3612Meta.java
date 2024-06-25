package org.demo.documentation.feature.drilldown.advancedonebcfilter;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.drilldown.advancedonebcfilter.enums.CustomFieldFilterDictionaryEnum;
import org.demo.documentation.feature.drilldown.advancedonebcfilter.MyExample3612DTO_;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

@Service
public class MyExample3612Meta extends FieldMetaBuilder<MyExample3612DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3612DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3612DTO_.customFieldFilterDictionary, CustomFieldFilterDictionaryEnum.values());
        fields.setEnabled(MyExample3612DTO_.customFieldFilterDictionary);
        fields.setEnabled(MyExample3612DTO_.customFieldFilterDate);
        fields.setEnabled(MyExample3612DTO_.customField);
        fields.setRequired(MyExample3612DTO_.customField);
        // --8<-- [start:urlBC]
        String urlBC = "/screen/myexample3612/view/myexample3612list" + "/" + CxboxMyExample3612Controller.myexample3612;
        // --8<-- [end:urlBC]
        // --8<-- [start:urlFilter]
        String urlFilterForField = URLEncoder.encode("customFieldFilterDictionary.equalsOneOf=%5B%22Low%22%2C%22Middle%22%5D");
        String urlFilter = "?filters={\""
                + CxboxMyExample3612Controller.myexample3612
                + "\":\""
                + urlFilterForField
                + "\"}";
        // --8<-- [end:urlFilter]
        // --8<-- [start:url]
        fields.setDrilldown(
                MyExample3612DTO_.customField,
                DrillDownType.INNER,
                urlBC + urlFilter
        );
        // --8<-- [end:url]
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3612DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3612DTO_.customFieldFilterDictionary, CustomFieldFilterDictionaryEnum.values());
        fields.enableFilter(MyExample3612DTO_.customFieldFilterDictionary);
        fields.enableFilter(MyExample3612DTO_.customFieldFilterDate);
    }

}