package org.demo.documentation.navigation.tab.other.example1;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3123Meta extends FieldMetaBuilder<MyExample3123DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3123DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3123DTO_.customField);
        fields.setRequired(MyExample3123DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3123DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}