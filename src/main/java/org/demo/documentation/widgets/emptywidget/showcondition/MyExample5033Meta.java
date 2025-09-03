package org.demo.documentation.widgets.emptywidget.showcondition;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5033Meta extends FieldMetaBuilder<MyExample5033DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5033DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5033DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5033DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}