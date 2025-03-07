package org.demo.documentation.other.savewithparent.example2.parent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3131Meta extends FieldMetaBuilder<MyExample3131DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3131DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3131DTO_.customField);
        fields.setRequired(MyExample3131DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3131DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}