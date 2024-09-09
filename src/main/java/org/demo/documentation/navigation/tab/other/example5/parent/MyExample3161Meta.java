package org.demo.documentation.navigation.tab.other.example5.parent;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3161Meta extends FieldMetaBuilder<MyExample3161DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3161DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3161DTO_.customField);
        fields.setRequired(MyExample3161DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3161DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}