package org.demo.documentation.feature.fulltextsearch;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3614Meta extends FieldMetaBuilder<MyExample3614DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3614DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3614DTO_.address);
        fields.setEnabled(MyExample3614DTO_.fullName);
        fields.setEnabled(MyExample3614DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3614DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}