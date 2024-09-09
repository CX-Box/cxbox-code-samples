package org.demo.documentation.navigation.tab.other.example5;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3160Meta extends FieldMetaBuilder<MyExample3160DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3160DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3160DTO_.customField);
        fields.setRequired(MyExample3160DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3160DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}