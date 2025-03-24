package org.demo.documentation.feature.postaction.drilldownandwaituntil.allbutton;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3232Meta extends FieldMetaBuilder<MyExample3232DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3232DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3232DTO_.customField);
        fields.setEnabled(MyExample3232DTO_.customFieldForm);
        fields.setPlaceholder(MyExample3232DTO_.customFieldForm,"The search is performed on `customField` with an exact match.");
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3232DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}