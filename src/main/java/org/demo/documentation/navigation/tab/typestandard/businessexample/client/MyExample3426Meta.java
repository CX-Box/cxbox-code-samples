package org.demo.documentation.navigation.tab.typestandard.businessexample.client;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3426Meta extends FieldMetaBuilder<MyExample3426DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3426DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3426DTO_.address);
        fields.setEnabled(MyExample3426DTO_.customField);
        fields.setRequired(MyExample3426DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3426DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3426DTO_.address);
        fields.enableSort(MyExample3426DTO_.address);
        fields.enableSort(MyExample3426DTO_.customField);
    }

}