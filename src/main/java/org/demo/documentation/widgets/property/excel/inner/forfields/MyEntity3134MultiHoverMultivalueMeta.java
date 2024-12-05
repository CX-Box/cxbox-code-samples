package org.demo.documentation.widgets.property.excel.inner.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3134MultiHoverMultivalueMeta extends FieldMetaBuilder<MyEntity3134MultiHoverMultivalueDTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3134MultiHoverMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3134MultiHoverMultivalueDTO_.id);
        fields.setEnabled(MyEntity3134MultiHoverMultivalueDTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3134MultiHoverMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
