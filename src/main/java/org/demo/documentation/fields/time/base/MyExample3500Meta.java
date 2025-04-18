package org.demo.documentation.fields.time.base;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3500Meta extends FieldMetaBuilder<MyExample3500DTO> {
    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3500DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3500DTO_.customFieldhA);
        fields.setEnabled(MyExample3500DTO_.customField);
        fields.setEnabled(MyExample3500DTO_.customFieldh);
        fields.setEnabled(MyExample3500DTO_.customFieldhmm);
        fields.setEnabled(MyExample3500DTO_.customFieldhmmA);
        fields.setEnabled(MyExample3500DTO_.customFieldhmmssA);
        fields.setEnabled(MyExample3500DTO_.customFieldmm);
        fields.setEnabled(MyExample3500DTO_.customFieldmmss);
        fields.setEnabled(MyExample3500DTO_.customFieldss);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3500DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3500DTO_.customFieldhA);
        fields.enableFilter(MyExample3500DTO_.customField);
    }
    // --8<-- [end:buildIndependentMeta]
}