package org.demo.documentation.widgets.picklist.actions.createwithparent;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3074Meta extends FieldMetaBuilder<MyExample3074DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3074DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3074DTO_.customFieldRequred);
        fields.setEnabled(MyExample3074DTO_.customFieldText);
        fields.setEnabled(MyExample3074DTO_.customFieldId);
        fields.setEnabled(MyExample3074DTO_.customField);
        fields.setRequired(MyExample3074DTO_.customFieldRequred);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3074DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3074DTO_.customFieldRequred);
        fields.enableFilter(MyExample3074DTO_.customFieldText);
        fields.enableFilter(MyExample3074DTO_.customField);
    }

}