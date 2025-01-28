package org.demo.documentation.other.forceactive;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3204Meta extends FieldMetaBuilder<MyExample3204DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3204DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3204DTO_.customFieldDrillDown);
        fields.setEnabled(MyExample3204DTO_.customFieldFA);
        fields.setEnabled(MyExample3204DTO_.customField);
        fields.setDrilldown(
                MyExample3204DTO_.customFieldDrillDown,
                DrillDownType.INNER,
                "/screen/myexample3204/view/myexample3204form/" + CxboxMyExample3204Controller.myexample3204 + "/" + id
        );
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3204DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3204DTO_.customFieldDrillDown);
        fields.enableFilter(MyExample3204DTO_.customFieldFA);
        fields.setForceActive(MyExample3204DTO_.customFieldFA);
    }

}