package org.demo.documentation.widgets.filepreview.fieldslayoute;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5005Meta extends FieldMetaBuilder<MyExample5005DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5005DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5005DTO_.customFieldId);
        fields.setEnabled(MyExample5005DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5005DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample5005DTO_.customFieldId);
    }

}