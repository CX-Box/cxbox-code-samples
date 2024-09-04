package org.demo.navigation.tab.typeother.fourthlevel;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3126Meta extends FieldMetaBuilder<MyExample3126DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3126DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3126DTO_.customField);
        fields.setRequired(MyExample3126DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3126DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}