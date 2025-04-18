package org.demo.documentation.feature.drilldown.goingbackafterdrilldowncreate;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3622Meta extends FieldMetaBuilder<MyExample3622DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3622DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3622DTO_.customField);
        fields.setRequired(MyExample3622DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3622DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnabled(MyExample3622DTO_.customField);
        fields.enableSort(MyExample3622DTO_.customField);
    }

}