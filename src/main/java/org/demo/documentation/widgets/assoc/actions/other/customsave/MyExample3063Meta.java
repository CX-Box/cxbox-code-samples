package org.demo.documentation.widgets.assoc.actions.other.customsave;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3063Meta extends FieldMetaBuilder<MyExample3063DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3063DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3063DTO_.customFieldRequired);
        fields.setEnabled(MyExample3063DTO_.customField);
        fields.setRequired(MyExample3063DTO_.customFieldRequired);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3063DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3063DTO_.customFieldRequired);
        fields.enableFilter(MyExample3063DTO_.customField);
        fields.enableSort(MyExample3063DTO_.customFieldRequired);
        fields.enableSort(MyExample3063DTO_.customField);
        fields.enableSort(MyExample3063DTO_.customFieldDisplayedKey);
    }

}