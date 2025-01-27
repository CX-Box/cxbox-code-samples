package org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.inline;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3079PickPick0Meta extends FieldMetaBuilder<MyEntity3079PickPick0DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3079PickPick0DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3079PickPick0DTO_.id);
        fields.setEnabled(MyEntity3079PickPick0DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3079PickPick0DTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
