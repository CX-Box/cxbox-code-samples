package org.demo.documentation.widgets.property.showcondition.hiddenbc.parent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3185Meta extends FieldMetaBuilder<MyExample3185DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3185DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnabled(MyExample3185DTO_.customFieldCheckbox);
      fields.setEnabled(MyExample3185DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3185DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample3185DTO_.customFieldCheckbox);
    }

}