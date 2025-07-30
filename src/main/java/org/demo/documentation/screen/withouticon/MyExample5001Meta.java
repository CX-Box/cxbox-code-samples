package org.demo.documentation.screen.withouticon;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5001Meta extends FieldMetaBuilder<MyExample5001DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5001DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5001DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5001DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}