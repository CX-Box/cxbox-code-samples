package org.demo.documentation.widgets.assoc.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3090Meta extends FieldMetaBuilder<MyExample3090DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3090DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3090DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample3090DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3090DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3090DTO_.customFieldMultivalue);
    }

}