package org.demo.documentation.widgets.assoc.actions.createwithparent.parent;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3661Meta extends FieldMetaBuilder<MyExample3661DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3661DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3661DTO_.customField);
        fields.setRequired(MyExample3661DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3661DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}