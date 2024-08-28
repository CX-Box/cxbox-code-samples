package org.demo.documentation.widgets.list.actions.create.newview;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3066Meta extends FieldMetaBuilder<MyExample3066DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3066DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3066DTO_.customField);
        fields.setRequired(MyExample3066DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3066DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}