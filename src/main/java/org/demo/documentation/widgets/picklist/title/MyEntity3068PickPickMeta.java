package org.demo.documentation.widgets.picklist.title;

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
        fields.setEnabled(org.demo.documentation.widgets.picklist.title.MyEntity3068PickPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.picklist.title.MyEntity3068PickPickDTO_.customFieldPick);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3068PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
