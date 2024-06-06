package org.demo.documentation.widgets.info.showcondition.bycurrententity;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3103Meta extends FieldMetaBuilder<MyExample3103DTO> {
// --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3103DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3103DTO_.customField);
    }
   // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3103DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3103DTO_.customField);
    }
   // --8<-- [end:buildIndependentMeta]
}