package org.demo.documentation.widgets.assoc.actions;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3054MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3054MultiMultivalueDTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3054MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3054MultiMultivalueDTO_.id);
        fields.setEnabled(MyEntity3054MultiMultivalueDTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3054MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableSort(MyEntity3054MultiMultivalueDTO_.id);
        fields.enableSort(MyEntity3054MultiMultivalueDTO_.customField);

    }

}
