package org.demo.documentation.widgets.assoc.base.forfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3053MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3053MultiMultivalueDTO> {

    @Override
    // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3053MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3053MultiMultivalueDTO_.customFieldNew);
        fields.setEnabled(MyEntity3053MultiMultivalueDTO_.id);
        fields.setEnabled(MyEntity3053MultiMultivalueDTO_.customField);
    }

    // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3053MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableFilter(MyEntity3053MultiMultivalueDTO_.customFieldNew);

    }

}
