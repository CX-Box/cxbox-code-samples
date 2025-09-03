package org.demo.documentation.widgets.steps;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5023Meta extends FieldMetaBuilder<MyExample5023DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5023DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5023DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5023DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}