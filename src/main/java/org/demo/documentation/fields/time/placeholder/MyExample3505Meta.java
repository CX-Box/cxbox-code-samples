package org.demo.documentation.fields.time.placeholder;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3505Meta extends FieldMetaBuilder<MyExample3505DTO> {
// --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3505DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3505DTO_.customField);
        fields.setPlaceholder(MyExample3505DTO_.customField, "11:25:58");
    }
   // --8<-- [end:buildRowDependentMeta]
  
   // --8<-- [start:buildIndependentMeta]
  @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3505DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3505DTO_.customField);
    }
   // --8<-- [end:buildIndependentMeta]
}