package org.demo.documentation.widgets.additionallist.base.allfields.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3191PickPick0Meta extends FieldMetaBuilder<MyEntity3191PickPick0DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3191PickPick0DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3191PickPick0DTO_.id);
        fields.setEnabled(MyEntity3191PickPick0DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3191PickPick0DTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
