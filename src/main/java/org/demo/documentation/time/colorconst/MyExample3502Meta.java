package org.demo.documentation.time.colorconst;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3502Meta extends FieldMetaBuilder<MyExample3502DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3502DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3502DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3502DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3502DTO_.customField);
    }

}