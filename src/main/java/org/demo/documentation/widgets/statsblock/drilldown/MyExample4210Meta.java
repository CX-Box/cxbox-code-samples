package org.demo.documentation.widgets.statsblock.drilldown;

import lombok.NonNull;
import org.cxbox.core.controller.param.SearchOperation;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;

import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.demo.documentation.widgets.statsblock.drilldown.data.MyExample4208DTO_;
import org.demo.documentation.widgets.statsblock.drilldown.data.PlatformMyExample4208Controller;
import org.demo.documentation.widgets.statsblock.drilldown.data.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.demo.documentation.widgets.statsblock.drilldown.MyExample4210Dao.*;


@Service
public class MyExample4210Meta extends AnySourceFieldMetaBuilder<MyExample4210DTO> {


    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4210DTO> fields, BcDescription bc,
                                      String id, String parentId) {

        String urlBC = "/screen/myexample4210/view/myexample4210list" + "/" + PlatformMyExample4208Controller.myExampleBc4208;
        String urlFilter = "?filters={\"" + "customFieldFilterDictionary.equalsOneOf=%5B%22Low%22%2C%22High%22%5";

        fields.setDrilldown(
                MyExample4210DTO_.value,
                DrillDownType.INNER,
                urlBC + "?filters={\"" + urlFilter + "\"}"
        );
    }

    private String getStatusFilterValues(@NonNull String id) {
        if (COUNT_NEW_ROW_ID.equals(id)) {
            return CustomFieldEnum.NEW.getValue();
        } else if (COUNT_NEW_IN_PROGRESS_ROW_ID.equals(id)) {
            return CustomFieldEnum.NEW.getValue() + "," + CustomFieldEnum.IN_PROGRESS.getValue();
        }

        throw new IllegalStateException("Unexpected value: " + id);
    }

    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4210DTO> fields, BcDescription bc, String parentId) {
    }
    // --8<-- [end:buildIndependentMeta]
}