package org.demo.documentation.widgets.picklist.title.withtitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3068PickPickMeta extends FieldMetaBuilder<MyEntity3068PickPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3068PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3068PickPickDTO_.id);
        fields.setEnabled(MyEntity3068PickPickDTO_.customFieldPick);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3068PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableSort(MyEntity3068PickPickDTO_.id);
        fields.enableSort(MyEntity3068PickPickDTO_.customFieldPick);

    }

}
