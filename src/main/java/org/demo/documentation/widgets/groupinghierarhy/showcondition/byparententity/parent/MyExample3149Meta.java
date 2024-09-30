package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.parent;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3149Meta extends FieldMetaBuilder<MyExample3149DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3149DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3149DTO_.customField);
        fields.setRequired(MyExample3149DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3149DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}