package org.demo.documentation.widgets.emptywidget.colortitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5031Meta extends FieldMetaBuilder<MyExample5031DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5031DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5031DTO_.customFieldText);
        fields.setEnabled(MyExample5031DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5031DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}