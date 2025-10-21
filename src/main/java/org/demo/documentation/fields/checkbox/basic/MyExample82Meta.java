package org.demo.documentation.fields.checkbox.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MyExample82Meta extends FieldMetaBuilder<MyExample82DTO> {

    private final DocumentConfig configuration;

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample82DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample82DTO_.customField11);
        fields.setEnabled(MyExample82DTO_.customField10);
        fields.setEnabled(MyExample82DTO_.customField9);
        fields.setEnabled(MyExample82DTO_.customField8);
        fields.setEnabled(MyExample82DTO_.customField7);
        fields.setEnabled(MyExample82DTO_.customField3);
        fields.setEnabled(MyExample82DTO_.customField2);
        fields.setEnabled(MyExample82DTO_.customField6);
        fields.setEnabled(MyExample82DTO_.customField4);
        fields.setEnabled(MyExample82DTO_.customField5);
        fields.setEnabled(MyExample82DTO_.dsgfsg);
        fields.setEnabled(MyExample82DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample82DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample82DTO_.customField11);
        fields.enableFilter(MyExample82DTO_.customField10);
        fields.enableFilter(MyExample82DTO_.customField9);
        fields.enableFilter(MyExample82DTO_.customField8);
        fields.enableFilter(MyExample82DTO_.customField7);
        fields.enableFilter(MyExample82DTO_.customField3);
        fields.enableFilter(MyExample82DTO_.customField2);
        fields.enableFilter(MyExample82DTO_.customField6);
        fields.enableFilter(MyExample82DTO_.customField4);
        fields.enableFilter(MyExample82DTO_.customField5);
        fields.enableFilter(MyExample82DTO_.dsgfsg);
        if (configuration.getForceActiveEnabled()) {
            fields.setForceActive(MyExample82DTO_.customField);
        }
        fields.enableFilter(MyExample82DTO_.customField);
        if (configuration.getForceActiveEnabled()) {
            fields.setForceActive(MyExample82DTO_.customField);
        }
    }

}