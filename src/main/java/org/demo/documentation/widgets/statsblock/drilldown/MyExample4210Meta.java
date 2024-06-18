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

import static org.demo.documentation.widgets.statsblock.drilldown.data.enums.CustomFieldEnum.CLOSE;
import static org.demo.documentation.widgets.statsblock.drilldown.data.enums.CustomFieldEnum.NEW;

@Service
public class MyExample4210Meta extends AnySourceFieldMetaBuilder<MyExample4210DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4210DTO> fields, BcDescription bc,
                                      String id, String parentId) {
        fields.setDrilldown(
                MyExample4210DTO_.value,
                DrillDownType.INNER,
                "/screen/client/view/clientlist"
                        + "/" + PlatformMyExample4210Controller.myExampleBc4210
                        + "?filters={\""
                        + PlatformMyExample4208Controller.myExampleBc4208
                        + "\":\""
                        + MyExample4208DTO_.customFieldStatus.getName() + "." + SearchOperation.EQUALS_ONE_OF.getOperationName()
                        + "=[\\\""
                        + getStatusFilterValues(id)
                        + "\\\"]"
                        + "\"}"
        );
    }
    private String getStatusFilterValues(@NonNull String id) {
        if (NEW.equals(id)) {
            return CustomFieldEnum.NEW.getValue();
        } else if (CLOSE.equals(id)) {
            return CustomFieldEnum.CLOSE.getValue();
        }
        throw new IllegalStateException("Unexpected value: " + id);
    }
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4210DTO> fields, BcDescription bc, String parentId) {
    }

}