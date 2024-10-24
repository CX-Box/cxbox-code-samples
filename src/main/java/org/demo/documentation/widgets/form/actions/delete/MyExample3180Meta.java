package org.demo.documentation.widgets.form.actions.delete;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3180Meta extends FieldMetaBuilder<MyExample3180DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3180DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3180DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3180DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}