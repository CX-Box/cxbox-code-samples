package org.demo.documentation.widgets.form.actions.save;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3181Meta extends FieldMetaBuilder<MyExample3181DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3181DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3181DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3181DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}