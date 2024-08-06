package org.demo.documentation.other.twobcshowcondition.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3145Meta extends FieldMetaBuilder<MyExample3145DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3145DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3145DTO_.customField);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3145DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}