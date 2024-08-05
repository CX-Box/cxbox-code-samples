package org.demo.documentation.feature.microservice.old_createmicroservices;


import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3810Meta extends AnySourceFieldMetaBuilder<MyExample3810DTO> {
// --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3810DTO>  fields, BcDescription bc,
                                      String id, String parentId) {
    }
   // --8<-- [end:buildRowDependentMeta]
  
   // --8<-- [start:buildIndependentMeta]
  @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3810DTO> fields, BcDescription bcDescription,
                                     String parentId) {
        fields.enableFilter(MyExample3810DTO_.customField);
        fields.enableFilter(MyExample3810DTO_.customFieldDateTime);
    }

}