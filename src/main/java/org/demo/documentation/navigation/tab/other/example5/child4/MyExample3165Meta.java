package org.demo.documentation.navigation.tab.other.example5.child4;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.navigation.tab.other.example5.CxboxMyExample3160Controller;
import org.demo.documentation.navigation.tab.other.example5.child3.MyEntity3163;
import org.demo.documentation.navigation.tab.other.example5.child3.MyEntity3163Repository;

import org.springframework.stereotype.Service;

@Service
public class MyExample3165Meta extends FieldMetaBuilder<MyExample3165DTO> {
    private final MyEntity3163Repository repository3163;

    public MyExample3165Meta(MyEntity3163Repository repository3163) {
        this.repository3163 = repository3163;
    }


    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3165DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3165DTO_.customField);
        fields.setRequired(MyExample3165DTO_.customField);
        MyEntity3163 entity3163 = repository3163.findById(parentId).orElse(null);
        if (entity3163 != null) {
            fields.setDrilldown(
                    MyExample3165DTO_.customField,
                    DrillDownType.INNER,
                    "/screen/myexample3160/view/myexample3160for11/" + CxboxMyExample3160Controller.myexample3161 + "/"
                            + entity3163.getCustomFieldEntity().getId()+ "/"
                            + CxboxMyExample3160Controller.myexample3163 + "/"
                            + parentId + "/"
                            + CxboxMyExample3160Controller.myexample3165 + "/"
                            + id);
        }

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3165DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}