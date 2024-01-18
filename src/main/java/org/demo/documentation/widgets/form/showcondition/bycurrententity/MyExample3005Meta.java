package org.demo.documentation.widgets.form.showcondition.bycurrententity;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3005Meta extends FieldMetaBuilder<MyExample3005DTO> {

    private final DocumentConfig configuration;

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3005DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(
                MyExample3005DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3005DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3005DTO_.customField2);

        fields.enableFilter(MyExample3005DTO_.customField);
        if (configuration.getForceActiveEnabled()) {
            fields.setForceActive(MyExample3005DTO_.customField);
            fields.setForceActive(MyExample3005DTO_.customFieldShowCondition);
        }
    }
    // --8<-- [end:buildIndependentMeta]

}