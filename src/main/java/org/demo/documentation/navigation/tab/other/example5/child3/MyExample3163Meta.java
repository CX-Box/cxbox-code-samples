package org.demo.documentation.navigation.tab.other.example5.child3;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.navigation.tab.other.example5.CxboxMyExample3160Controller;

import org.springframework.stereotype.Service;

@Service
public class MyExample3163Meta extends FieldMetaBuilder<MyExample3163DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3163DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3163DTO_.customField);
        fields.setRequired(MyExample3163DTO_.customField);
        fields.setDrilldown(
                MyExample3163DTO_.customField,
                DrillDownType.INNER,
                "/screen/myexample3160/view/myexample3160form8/" + CxboxMyExample3160Controller.myexample3161 + "/"
                        + parentId
                        + CxboxMyExample3160Controller.myexample3163 + "/"
                        +  id);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3163DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}