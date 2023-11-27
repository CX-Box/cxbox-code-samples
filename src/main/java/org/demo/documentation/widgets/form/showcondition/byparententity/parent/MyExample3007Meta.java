package org.demo.documentation.widgets.form.showcondition.byparententity.parent;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3007Meta extends FieldMetaBuilder<MyExample3007DTO> {

    private final DocumentConfig configuration;

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3007DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3007DTO_.customField4);
        fields.setEnabled(MyExample3007DTO_.customField3);
        fields.setEnabled(MyExample3007DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3007DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3007DTO_.customFieldShowCondition);

        fields.enableFilter(MyExample3007DTO_.customField3);
        fields.enableFilter(MyExample3007DTO_.customField);
        if (configuration.getForceActiveEnabled()) {
            fields.setForceActive(MyExample3007DTO_.customField);
        }
    }
    // --8<-- [end:buildIndependentMeta]

}