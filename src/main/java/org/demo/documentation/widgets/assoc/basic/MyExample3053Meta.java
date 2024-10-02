package org.demo.documentation.widgets.assoc.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3053Meta extends FieldMetaBuilder<MyExample3053DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3053DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3053DTO_.customField);
        fields.setEnabled(MyExample3053DTO_.customField);
        fields.setRequired(MyExample3053DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3053DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3053DTO_.customField);
    }

}