package org.demo.documentation.feature.tab.thirdlevel;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3125Meta extends FieldMetaBuilder<MyExample3125DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3125DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3125DTO_.customField);
        fields.setRequired(MyExample3125DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3125DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}