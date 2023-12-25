package org.demo.documentation.widgets.list.showcondition.bycurrententity;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3101Meta extends FieldMetaBuilder<MyExample3101DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3101DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3101DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3101DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3101DTO_.customField);
    }

}