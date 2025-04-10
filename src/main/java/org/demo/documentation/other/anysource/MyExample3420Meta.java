package org.demo.documentation.other.anysource;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3420Meta extends AnySourceFieldMetaBuilder<MyExample3420DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3420DTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
        fields.setEnabled(MyExample3420DTO_.customField);
        fields.setEnabled(MyExample3420DTO_.customFieldNew);
        fields.setEnabled(MyExample3420DTO_.customFieldDouble);
        fields.setEnabled(MyExample3420DTO_.customFieldDateTime);
        fields.setPlaceholder(MyExample3420DTO_.customFieldDouble,"More than 100 000.00");
        fields.setPlaceholder(MyExample3420DTO_.customFieldDateTime,"Less sysdate");
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3420DTO> fields, BcDescription bcDescription, String parentId) {
        fields.setForceActive(MyExample3420DTO_.customField);
        fields.enableSort(MyExample3420DTO_.customField);
        fields.setForceActive(MyExample3420DTO_.customFieldNew);
        fields.enableSort(MyExample3420DTO_.customFieldNew);
        fields.setForceActive(MyExample3420DTO_.customFieldDateTime);
        fields.enableSort(MyExample3420DTO_.customFieldDateTime);
        fields.setForceActive(MyExample3420DTO_.customFieldDouble);
        fields.enableSort(MyExample3420DTO_.customFieldDouble);
    }

}
