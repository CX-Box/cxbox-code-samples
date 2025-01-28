package org.demo.documentation.other.savewithparent.example3;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3422Meta extends FieldMetaBuilder<MyExample3422DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3422DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3422DTO_.customFieldDrilldown);
        fields.setEnabled(MyExample3422DTO_.customField);
        fields.setRequired(MyExample3422DTO_.customField);
        fields.setDrilldown(
                MyExample3422DTO_.customFieldDrilldown,
                DrillDownType.INNER,
                "/screen/myexample3422/view/taskinfo/" + CxboxMyExample3422Controller.myexample3422 + "/" + id
        );
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3422DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3422DTO_.customFieldDrilldown);
        fields.enableSort(MyExample3422DTO_.customFieldDrilldown);
    }

}