package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3148Meta extends FieldMetaBuilder<MyExample3148DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3148DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3148DTO_.customField);
        fields.setRequired(MyExample3148DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3148DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}