package org.demo.documentation.widgets.formpopup.colortitle;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3027Meta extends FieldMetaBuilder<MyExample3027DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3027DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3027DTO_.customField);
        fields.setRequired(MyExample3027DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3027DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}