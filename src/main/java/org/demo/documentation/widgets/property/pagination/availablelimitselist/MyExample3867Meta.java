package org.demo.documentation.widgets.property.pagination.availablelimitselist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3867Meta extends FieldMetaBuilder<MyExample3867DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3867DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3867DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3867DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}