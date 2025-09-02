package org.demo.documentation.widgets.headerwidget.fieldslayoute;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5025Meta extends FieldMetaBuilder<MyExample5025DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5025DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5025DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5025DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}