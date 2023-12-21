package org.demo.documentation.widgets.list.fieldslayoute;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3100Meta extends FieldMetaBuilder<MyExample3100DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3100DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3100DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}