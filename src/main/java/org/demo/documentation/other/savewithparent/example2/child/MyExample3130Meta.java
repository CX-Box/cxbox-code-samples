package org.demo.documentation.other.savewithparent.example2.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3130Meta extends FieldMetaBuilder<MyExample3130DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3130DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3130DTO_.customField);
        fields.setRequired(MyExample3130DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3130DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}