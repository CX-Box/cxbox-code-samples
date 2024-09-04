package org.demo.navigation.tab.typeother.secondlevel.down;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3127Meta extends FieldMetaBuilder<MyExample3127DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3127DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3127DTO_.customField);
        fields.setRequired(MyExample3127DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3127DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}