package org.demo.documentation.widgets.additionallist.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3195Meta extends FieldMetaBuilder<MyExample3195DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3195DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3195DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3195DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}