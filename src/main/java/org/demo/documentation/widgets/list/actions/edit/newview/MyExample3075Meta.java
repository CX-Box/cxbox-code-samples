package org.demo.documentation.widgets.list.actions.edit.newview;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3075Meta extends FieldMetaBuilder<MyExample3075DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3075DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3075DTO_.customFieldText);
        fields.setEnabled(MyExample3075DTO_.customField);
        fields.setRequired(MyExample3075DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3075DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3075DTO_.customFieldText);
    }

}