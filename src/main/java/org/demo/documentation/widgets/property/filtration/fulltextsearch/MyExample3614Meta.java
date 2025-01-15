package org.demo.documentation.widgets.property.filtration.fulltextsearch;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3614Meta extends FieldMetaBuilder<MyExample3614DTO> {

    @Override
    // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3614DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3614DTO_.customFieldMultivalueDisplayedKey);
        fields.setEnabled(MyExample3614DTO_.address);
        fields.setEnabled(MyExample3614DTO_.fullName);
        fields.setEnabled(MyExample3614DTO_.customField);
    }

    // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3614DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3614DTO_.customFieldMultivalueDisplayedKey);
        fields.enableSort(MyExample3614DTO_.address);
        fields.enableSort(MyExample3614DTO_.fullName);
        fields.enableSort(MyExample3614DTO_.customField);
    }

}