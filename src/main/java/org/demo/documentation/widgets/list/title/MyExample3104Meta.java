package org.demo.documentation.widgets.list.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3104Meta extends FieldMetaBuilder<MyExample3104DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3104DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3104DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3104DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3104DTO_.customField);
    }

}