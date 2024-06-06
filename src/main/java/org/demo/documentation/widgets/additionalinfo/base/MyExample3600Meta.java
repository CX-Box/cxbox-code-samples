package org.demo.documentation.widgets.additionalinfo.base;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3600Meta extends FieldMetaBuilder<MyExample3600DTO> {
// --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3600DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnabled(MyExample3600DTO_.customField3);
      fields.setEnabled(MyExample3600DTO_.customField2);
      fields.setEnabled(MyExample3600DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
  
   // --8<-- [start:buildIndependentMeta]
  @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3600DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample3600DTO_.customField3);
      fields.enableFilter(MyExample3600DTO_.customField2);
      fields.enableFilter(MyExample3600DTO_.customField);
    }
   // --8<-- [end:buildIndependentMeta]
}