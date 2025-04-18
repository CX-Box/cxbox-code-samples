package org.demo.documentation.widgets.picklist.actions.create.picklist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3072PickPickMeta extends FieldMetaBuilder<MyEntity3072PickPickDTO> {

    @Override
    // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3072PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3072PickPickDTO_.id);
        fields.setEnabled(MyEntity3072PickPickDTO_.customFieldPick);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3072PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableSort(MyEntity3072PickPickDTO_.id);
        fields.enableSort(MyEntity3072PickPickDTO_.customFieldPick);

    }
    // --8<-- [end:buildIndependentMeta]
}
