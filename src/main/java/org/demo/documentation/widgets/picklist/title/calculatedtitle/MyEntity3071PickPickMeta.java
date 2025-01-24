package org.demo.documentation.widgets.picklist.title.calculatedtitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3071PickPickMeta extends FieldMetaBuilder<MyEntity3071PickPickDTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3071PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3071PickPickDTO_.id);
        fields.setEnabled(MyEntity3071PickPickDTO_.customFieldPick);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3071PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

        fields.enableSort(org.demo.documentation.widgets.picklist.title.calculatedtitle.MyEntity3071PickPickDTO_.id);
        fields.enableSort(org.demo.documentation.widgets.picklist.title.calculatedtitle.MyEntity3071PickPickDTO_.customFieldPick);

    }

}
