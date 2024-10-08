package org.demo.documentation.widgets.form.action.edit.withview;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3303Meta extends FieldMetaBuilder<MyExample3303DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3303DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3303DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3303DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}