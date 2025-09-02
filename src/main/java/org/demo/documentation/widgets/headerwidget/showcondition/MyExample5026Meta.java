package org.demo.documentation.widgets.headerwidget.showcondition;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5026Meta extends FieldMetaBuilder<MyExample5026DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5026DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5026DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5026DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}