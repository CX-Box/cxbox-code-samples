package org.demo.navigation.tab.other.example4;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3156Meta extends FieldMetaBuilder<MyExample3156DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3156DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3156DTO_.customField);
        fields.setRequired(MyExample3156DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3156DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}