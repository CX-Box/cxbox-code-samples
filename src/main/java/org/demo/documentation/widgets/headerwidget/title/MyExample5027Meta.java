package org.demo.documentation.widgets.headerwidget.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5027Meta extends FieldMetaBuilder<MyExample5027DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5027DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5027DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5027DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}