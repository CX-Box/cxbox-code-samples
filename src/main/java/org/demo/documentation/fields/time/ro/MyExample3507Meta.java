package org.demo.documentation.fields.time.ro;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3507Meta extends FieldMetaBuilder<MyExample3507DTO> {
// --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3507DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
    }
   // --8<-- [end:buildRowDependentMeta]
  
   // --8<-- [start:buildIndependentMeta]
  @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3507DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample3507DTO_.customField);
    }
   // --8<-- [end:buildIndependentMeta]
}