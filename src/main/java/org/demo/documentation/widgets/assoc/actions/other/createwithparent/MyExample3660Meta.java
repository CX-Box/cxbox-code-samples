package org.demo.documentation.widgets.assoc.actions.other.createwithparent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3660Meta extends FieldMetaBuilder<MyExample3660DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3660DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3660DTO_.customFieldReq);
        fields.setEnabled(MyExample3660DTO_.customFieldTextReq);
        fields.setEnabled(MyExample3660DTO_.customFieldText);
        fields.setEnabled(MyExample3660DTO_.customField);
        fields.setRequired(MyExample3660DTO_.customFieldReq);
        fields.setRequired(MyExample3660DTO_.customFieldTextReq);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3660DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3660DTO_.customFieldReq);
        fields.enableFilter(MyExample3660DTO_.customFieldTextReq);
        fields.enableFilter(MyExample3660DTO_.customFieldText);
        fields.enableFilter(MyExample3660DTO_.customField);
    }

}