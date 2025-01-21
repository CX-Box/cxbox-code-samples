package org.demo.documentation.feature.drilldown.byscreen;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
 
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3619Meta extends FieldMetaBuilder<MyExample3619DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3619DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3619DTO_.customField);
        fields.setRequired(MyExample3619DTO_.customField);

        fields.setDrilldown(
                MyExample3619DTO_.customField,
                DrillDownType.INNER,
                "/screen/myexample3610"
        );
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3619DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}