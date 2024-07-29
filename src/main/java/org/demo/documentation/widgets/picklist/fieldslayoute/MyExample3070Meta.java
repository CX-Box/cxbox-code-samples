package org.demo.documentation.widgets.picklist.fieldslayoute;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3070Meta extends FieldMetaBuilder<MyExample3070DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3070DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3070DTO_.customFieldId);
        fields.setEnabled(MyExample3070DTO_.customField);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3070DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3070DTO_.customField);
    }

}