package org.demo.documentation.widgets.statsblock.title;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample4209Meta extends FieldMetaBuilder<MyExample4209DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4209DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4209DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4209DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample4209DTO_.customField);
    }

}