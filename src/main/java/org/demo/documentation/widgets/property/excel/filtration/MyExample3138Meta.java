package org.demo.documentation.widgets.property.excel.filtration;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3138Meta extends FieldMetaBuilder<MyExample3138DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3138DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3138DTO_.customFieldText);
        fields.setEnabled(MyExample3138DTO_.customFieldInput);
        fields.setEnabled(MyExample3138DTO_.customFieldNumber);
        fields.setEnabled(MyExample3138DTO_.customFieldDateTime);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3138DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3138DTO_.customFieldText);
        fields.enableSort(MyExample3138DTO_.customFieldText);
        fields.enableFilter(MyExample3138DTO_.customFieldInput);
        fields.enableSort(MyExample3138DTO_.customFieldInput);
        fields.enableFilter(MyExample3138DTO_.customFieldNumber);
        fields.enableSort(MyExample3138DTO_.customFieldNumber);
        fields.enableFilter(MyExample3138DTO_.customFieldDateTime);
        fields.enableSort(MyExample3138DTO_.customFieldDateTime);
    }

}