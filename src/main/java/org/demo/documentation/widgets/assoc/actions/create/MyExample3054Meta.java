package org.demo.documentation.widgets.assoc.actions.create;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3054Meta extends FieldMetaBuilder<MyExample3054DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3054DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3054DTO_.customField);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3054DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3054DTO_.customField);
    }

}