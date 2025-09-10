package org.demo.documentation.widgets.statsblock.drilldown.parentchild;

import lombok.NonNull;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;


@Service
public class MyExample4127Meta extends AnySourceFieldMetaBuilder<MyExample4127DTO> {


    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4127DTO> fields, BcDescription bc,
                                      String id, String parentId) {
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4127DTO> fields, BcDescription bc, String parentId) {
    }
    // --8<-- [end:buildIndependentMeta]
}