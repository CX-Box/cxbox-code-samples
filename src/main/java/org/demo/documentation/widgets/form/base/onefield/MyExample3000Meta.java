package org.demo.documentation.widgets.form.base.onefield;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3000Meta extends FieldMetaBuilder<MyExample3000DTO> {

    private final DocumentConfig configuration;

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3000DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {

        fields.setEnabled(MyExample3000DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3000DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        if (configuration.getForceActiveEnabled()) {
            fields.setForceActive(MyExample3000DTO_.customField);
        }
        fields.enableFilter(MyExample3000DTO_.customField);
    }
    // --8<-- [end:buildIndependentMeta]

}