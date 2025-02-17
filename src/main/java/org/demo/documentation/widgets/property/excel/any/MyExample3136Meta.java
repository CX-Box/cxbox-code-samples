package org.demo.documentation.widgets.property.excel.any;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3136Meta extends AnySourceFieldMetaBuilder<MyExample3136DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3136DTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3136DTO> fields, BcDescription bcDescription, String parentId) {
        fields.enableSort(MyExample3136DTO_.customField);
        fields.enableSort(MyExample3136DTO_.customFieldDateTime);
    }

}
