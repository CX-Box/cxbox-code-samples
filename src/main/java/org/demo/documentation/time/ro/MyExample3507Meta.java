package org.demo.documentation.time.ro;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3507Meta extends FieldMetaBuilder<MyExample3507DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3507DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3507DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample3507DTO_.customField);
    }

}