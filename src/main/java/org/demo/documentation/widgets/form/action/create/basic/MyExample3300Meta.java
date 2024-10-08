package org.demo.documentation.widgets.form.action.create.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3300Meta extends FieldMetaBuilder<MyExample3300DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3300DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3300DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3300DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}