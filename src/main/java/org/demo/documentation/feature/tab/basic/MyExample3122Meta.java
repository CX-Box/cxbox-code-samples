package org.demo.documentation.feature.tab.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3122Meta extends FieldMetaBuilder<MyExample3122DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3122DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3122DTO_.customField);
        fields.setRequired(MyExample3122DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3122DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}