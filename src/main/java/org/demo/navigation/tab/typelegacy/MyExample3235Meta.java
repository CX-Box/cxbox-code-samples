package org.demo.navigation.tab.typelegacy;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3235Meta extends FieldMetaBuilder<MyExample3235DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3235DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3235DTO_.customField);
        fields.setRequired(MyExample3235DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3235DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}