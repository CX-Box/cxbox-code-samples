package org.demo.documentation.widgets.list.actions.edit.withwidget;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3065Meta extends FieldMetaBuilder<MyExample3065DTO> {

    @Override
    // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3065DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3065DTO_.fdsfdsfId);
        fields.setEnabled(MyExample3065DTO_.fdsfdsf);
        fields.setEnabled(MyExample3065DTO_.dsfgsgsId);
        fields.setEnabled(MyExample3065DTO_.dsfgsgs);
        fields.setEnabled(MyExample3065DTO_.hkjhkj);
        fields.setEnabled(MyExample3065DTO_.fjhjklId);
        fields.setEnabled(MyExample3065DTO_.fjhjkl);
        fields.setEnabled(MyExample3065DTO_.dfgjhklId);
        fields.setEnabled(MyExample3065DTO_.dfgjhkl);
        fields.setEnabled(MyExample3065DTO_.customFieldText);
        fields.setEnabled(MyExample3065DTO_.customField);
    }

    // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3065DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3065DTO_.fdsfdsf);
        fields.enableFilter(MyExample3065DTO_.dsfgsgs);
        fields.enableFilter(MyExample3065DTO_.hkjhkj);
        fields.enableFilter(MyExample3065DTO_.fjhjkl);
        fields.enableFilter(MyExample3065DTO_.dfgjhkl);
        fields.enableFilter(MyExample3065DTO_.customFieldText);
    }

}