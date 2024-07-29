package org.demo.documentation.widgets.picklist.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3067PickPickMeta extends FieldMetaBuilder<MyEntity3067PickPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3067PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.picklist.basic.MyEntity3067PickPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.picklist.basic.MyEntity3067PickPickDTO_.customFieldPick);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3067PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
