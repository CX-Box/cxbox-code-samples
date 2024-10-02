package org.demo.documentation.widgets.assoc.colortitle.allfields.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3052MultiMultiAssocMultivalueMeta extends FieldMetaBuilder<MyEntity3052MultiMultiAssocMultivalueDTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3052MultiMultiAssocMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3052MultiMultiAssocMultivalueDTO_.id);
        fields.setEnabled(MyEntity3052MultiMultiAssocMultivalueDTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3052MultiMultiAssocMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
