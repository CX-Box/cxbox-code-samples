package org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.enums.StatusEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3238Meta extends FieldMetaBuilder<MyExample3238DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3238DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3238DTO_.status, StatusEnum.values());
        fields.setEnabled(MyExample3238DTO_.status);
        fields.setEnabled(MyExample3238DTO_.address);
        fields.setEnabled(MyExample3238DTO_.fullName);
        fields.setEnabled(MyExample3238DTO_.customField);

        fields.setDrilldown(
                MyExample3238DTO_.fullName,
                DrillDownType.INNER,
                "/screen/myexample3238/view/myexample3238form/" + CxboxMyExample3238Controller.myexample3238 + "/" + id
        );
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3238DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3238DTO_.status, StatusEnum.values());
        fields.enableFilter(MyExample3238DTO_.status);
        fields.enableFilter(MyExample3238DTO_.address);
        fields.enableFilter(org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.MyExample3238DTO_.fullName);
    }

}