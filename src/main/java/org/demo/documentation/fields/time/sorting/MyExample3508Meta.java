package org.demo.documentation.fields.time.sorting;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3508Meta extends FieldMetaBuilder<MyExample3508DTO> {
    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3508DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3508DTO_.customField);
        fields.setEnabled(MyExample3508DTO_.customFieldhA);
        fields.setEnabled(MyExample3508DTO_.customFieldh);
        fields.setEnabled(MyExample3508DTO_.customFieldmm);
        fields.setEnabled(MyExample3508DTO_.customFieldhmm);
        fields.setEnabled(MyExample3508DTO_.customFieldhmmA);
        fields.setEnabled(MyExample3508DTO_.customFieldhmmssA);
        fields.setEnabled(MyExample3508DTO_.customFieldss);
        fields.setEnabled(MyExample3508DTO_.customFieldmmss);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3508DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableSort(MyExample3508DTO_.customField);
        fields.enableSort(MyExample3508DTO_.customFieldhA);
        fields.enableSort(MyExample3508DTO_.customFieldh);
        fields.enableSort(MyExample3508DTO_.customFieldmm);
        fields.enableSort(MyExample3508DTO_.customFieldhmm);
        fields.enableSort(MyExample3508DTO_.customFieldhmmA);
        fields.enableSort(MyExample3508DTO_.customFieldhmmssA);
        fields.enableSort(MyExample3508DTO_.customFieldss);
        fields.enableSort(MyExample3508DTO_.customFieldmmss);
    }
    // --8<-- [end:buildIndependentMeta]
}