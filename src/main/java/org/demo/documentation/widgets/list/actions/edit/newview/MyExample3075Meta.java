package org.demo.documentation.widgets.list.actions.edit.newview;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3075Meta extends FieldMetaBuilder<MyExample3075DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3075DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3075DTO_.customFieldText);
        fields.setEnabled(MyExample3075DTO_.customField);
        fields.setRequired(MyExample3075DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3075DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3075DTO_.customFieldText);
    }

}