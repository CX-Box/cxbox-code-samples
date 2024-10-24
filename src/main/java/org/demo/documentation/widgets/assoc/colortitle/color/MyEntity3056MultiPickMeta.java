package org.demo.documentation.widgets.assoc.colortitle.color;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3056MultiPickMeta extends FieldMetaBuilder<MyEntity3056MultiPickDTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3056MultiPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3056MultiPickDTO_.customFieldText);
        fields.setEnabled(MyEntity3056MultiPickDTO_.id);
        fields.setEnabled(MyEntity3056MultiPickDTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3056MultiPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableFilter(MyEntity3056MultiPickDTO_.customFieldText);

    }

}
