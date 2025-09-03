package org.demo.documentation.widgets.headerwidget.colortitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5024Meta extends FieldMetaBuilder<MyExample5024DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5024DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5024DTO_.customFieldText);
        fields.setEnabled(MyExample5024DTO_.customField);
        fields.setEnabled(MyExample5024DTO_.customFieldColor);
        fields.setEnabled(MyExample5024DTO_.customFieldTextColor);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5024DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample5024DTO_.customFieldText);
    }

}