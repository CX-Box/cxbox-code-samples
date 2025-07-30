package org.demo.documentation.screen.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5000Meta extends FieldMetaBuilder<MyExample5000DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5000DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5000DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5000DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}