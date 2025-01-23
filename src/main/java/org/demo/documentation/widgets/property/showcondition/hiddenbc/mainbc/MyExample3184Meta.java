package org.demo.documentation.widgets.property.showcondition.hiddenbc.mainbc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3184Meta extends FieldMetaBuilder<MyExample3184DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3184DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3184DTO_.customFieldCheckbox);
        fields.setEnabled(MyExample3184DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3184DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3184DTO_.customFieldCheckbox);
    }

}