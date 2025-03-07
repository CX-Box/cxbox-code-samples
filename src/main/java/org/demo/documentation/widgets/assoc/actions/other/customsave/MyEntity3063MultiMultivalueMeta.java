package org.demo.documentation.widgets.assoc.actions.other.customsave;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3063MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3063MultiMultivalueDTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3063MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3063MultiMultivalueDTO_.id);
        fields.setEnabled(MyEntity3063MultiMultivalueDTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3063MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableSort(MyEntity3063MultiMultivalueDTO_.id);
        fields.enableSort(MyEntity3063MultiMultivalueDTO_.customField);

    }

}
