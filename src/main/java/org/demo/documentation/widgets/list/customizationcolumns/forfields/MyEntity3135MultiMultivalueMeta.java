package org.demo.documentation.widgets.list.customizationcolumns.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3135MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3135MultiMultivalueDTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3135MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3135MultiMultivalueDTO_.id);
        fields.setEnabled(MyEntity3135MultiMultivalueDTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3135MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}