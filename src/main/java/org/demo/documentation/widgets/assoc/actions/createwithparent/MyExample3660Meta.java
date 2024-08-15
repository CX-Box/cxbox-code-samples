package org.demo.documentation.widgets.assoc.actions.createwithparent;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3660Meta extends FieldMetaBuilder<MyExample3660DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3660DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3660DTO_.customFieldReq);
        fields.setEnabled(MyExample3660DTO_.customFieldTextReq);
        fields.setEnabled(MyExample3660DTO_.customFieldText);
        fields.setEnabled(MyExample3660DTO_.customField);
        fields.setRequired(MyExample3660DTO_.customFieldReq);
        fields.setRequired(MyExample3660DTO_.customFieldTextReq);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3660DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3660DTO_.customFieldReq);
        fields.enableFilter(MyExample3660DTO_.customFieldTextReq);
        fields.enableFilter(MyExample3660DTO_.customFieldText);
        fields.enableFilter(MyExample3660DTO_.customField);
    }

}