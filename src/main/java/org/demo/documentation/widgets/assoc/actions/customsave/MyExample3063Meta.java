package org.demo.documentation.widgets.assoc.actions.customsave;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3063Meta extends FieldMetaBuilder<MyExample3063DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3063DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3063DTO_.customField);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3063DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3063DTO_.customField);
    }

}