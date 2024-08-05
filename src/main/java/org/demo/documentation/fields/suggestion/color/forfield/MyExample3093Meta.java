package org.demo.documentation.fields.suggestion.color.forfield;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3093Meta extends FieldMetaBuilder<MyExample3093DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3093DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3093DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3093DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}