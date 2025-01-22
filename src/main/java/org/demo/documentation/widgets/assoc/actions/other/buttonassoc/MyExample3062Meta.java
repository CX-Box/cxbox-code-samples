package org.demo.documentation.widgets.assoc.actions.other.buttonassoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3062Meta extends FieldMetaBuilder<MyExample3062DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3062DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3062DTO_.customFieldText);
        fields.setEnabled(MyExample3062DTO_.customField);

    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3062DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3062DTO_.customFieldText);
        fields.enableFilter(MyExample3062DTO_.customField);
    }

}