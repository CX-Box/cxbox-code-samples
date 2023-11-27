package org.demo.documentation.widgets.form.fieldslayoute;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3004Meta extends FieldMetaBuilder<MyExample3004DTO> {

    private final DocumentConfig configuration;

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3004DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {

        fields.setEnabled(MyExample3004DTO_.customField5);
        fields.setEnabled(MyExample3004DTO_.customField4);
        fields.setEnabled(MyExample3004DTO_.customField3);
        fields.setEnabled(MyExample3004DTO_.customField2);
        fields.setEnabled(MyExample3004DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3004DTO> fields, InnerBcDescription bcDescription, Long parentId) {

        fields.enableFilter(MyExample3004DTO_.customField5);
        fields.enableFilter(MyExample3004DTO_.customField4);
        fields.enableFilter(MyExample3004DTO_.customField3);
        fields.enableFilter(MyExample3004DTO_.customField2);
        fields.enableFilter(MyExample3004DTO_.customField);
        if (configuration.getForceActiveEnabled()) {
            fields.setForceActive(MyExample3004DTO_.customField);
        }
        fields.enableFilter(MyExample3004DTO_.customField);
    }
    // --8<-- [end:buildIndependentMeta]

}