package org.demo.documentation.fields.time.filtration;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3504Meta extends FieldMetaBuilder<MyExample3504DTO> {
    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3504DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3504DTO_.customFieldhA);
        fields.setEnabled(MyExample3504DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3504DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3504DTO_.customFieldhA);
        fields.enableFilter(MyExample3504DTO_.customField);
        fields.enableSort(MyExample3504DTO_.customField);
        fields.enableSort(MyExample3504DTO_.customFieldh);
        fields.enableSort(MyExample3504DTO_.customFieldmm);
        fields.enableSort(MyExample3504DTO_.customFieldhmm);
        fields.enableSort(MyExample3504DTO_.customFieldhmmA);
        fields.enableSort(MyExample3504DTO_.customFieldhmmssA);
        fields.enableSort(MyExample3504DTO_.customFieldss);
        fields.enableSort(MyExample3504DTO_.customFieldmmss);

    }
    // --8<-- [end:buildIndependentMeta]
}