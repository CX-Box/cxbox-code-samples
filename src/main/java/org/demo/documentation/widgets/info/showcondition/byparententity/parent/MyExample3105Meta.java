package org.demo.documentation.widgets.info.showcondition.byparententity.parent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3105Meta extends FieldMetaBuilder<MyExample3105DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3105DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3105DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3105DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3105DTO_.customField);
    }

}