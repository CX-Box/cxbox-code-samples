package org.demo.documentation.getstarted.postgres.document;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4000Meta extends FieldMetaBuilder<MyExample4000DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4000DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4000DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}