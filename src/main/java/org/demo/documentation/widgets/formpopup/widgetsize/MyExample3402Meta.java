package org.demo.documentation.widgets.formpopup.widgetsize;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3402Meta extends FieldMetaBuilder<MyExample3402DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3402DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3402DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3402DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}