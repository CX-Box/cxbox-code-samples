package org.demo.documentation.other.drilldown.option3;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3430Meta extends FieldMetaBuilder<MyExample3430DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3430DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3430DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3430DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}