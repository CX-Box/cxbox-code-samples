package org.demo.documentation.widgets.list.base.onefield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.list.base.allfields.MyExample3002DTO_;
import org.demo.documentation.widgets.list.base.allfields.PlatformMyExample3002Controller;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3189Meta extends FieldMetaBuilder<MyExample3189DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3189DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3189DTO_.customField);
        fields.setDrilldown(MyExample3189DTO_.customField,
                DrillDownType.INNER,
                "/screen/mytasks/view/mytaskslist2/" + CxboxMyExample3189Controller.myexample3189 + "/" + id
        );
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3189DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}