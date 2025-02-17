package org.demo.documentation.navigation.tab.typestandard.businessexample.task;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.navigation.tab.typestandard.businessexample.CxboxMyExample3428Controller;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3428Meta extends FieldMetaBuilder<MyExample3428DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3428DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3428DTO_.meetDate);
        fields.setEnabled(MyExample3428DTO_.customFieldAdditional);
        fields.setEnabled(MyExample3428DTO_.customFieldDrilldown);
        fields.setEnabled(MyExample3428DTO_.customField);
        fields.setRequired(MyExample3428DTO_.customField);
        fields.setDrilldown(
                MyExample3428DTO_.customFieldDrilldown,
                DrillDownType.INNER,
                "/screen/myexample3428/view/taskinfo/" + CxboxMyExample3428Controller.myexample3428 + "/" + id
        );
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3428DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3428DTO_.meetDate);
        fields.enableSort(MyExample3428DTO_.meetDate);
        fields.enableFilter(MyExample3428DTO_.customFieldAdditional);
        fields.enableSort(MyExample3428DTO_.customFieldAdditional);
        fields.enableFilter(MyExample3428DTO_.customFieldDrilldown);
        fields.enableSort(MyExample3428DTO_.customFieldDrilldown);
    }

}