package org.demo.documentation.feature.excel.filtration;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3138Meta extends FieldMetaBuilder<MyExample3138DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3138DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3138DTO_.customFieldText);
        fields.setEnabled(MyExample3138DTO_.customFieldInput);
        fields.setEnabled(MyExample3138DTO_.customFieldNumber);
        fields.setEnabled(MyExample3138DTO_.customFieldDateTime);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3138DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3138DTO_.customFieldText);
        fields.enableFilter(MyExample3138DTO_.customFieldInput);
        fields.enableFilter(MyExample3138DTO_.customFieldNumber);
        fields.enableFilter(MyExample3138DTO_.customFieldDateTime);
    }

}