package org.demo.navigation.tab.typeother.secondlevel.top;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3124Meta extends FieldMetaBuilder<MyExample3124DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3124DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3124DTO_.customField);
        fields.setRequired(MyExample3124DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3124DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}