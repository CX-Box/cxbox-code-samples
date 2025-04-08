package org.demo.documentation.widgets.additionalinfo.showcondition;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4231Meta extends FieldMetaBuilder<MyExample4231DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4231DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4231DTO_.customFieldNum);
        fields.setEnabled(MyExample4231DTO_.customField);
        fields.setRequired(MyExample4231DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4231DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample4231DTO_.customFieldNum);
        fields.enableSort(MyExample4231DTO_.customFieldNum);
    }

}
