package org.demo.documentation.widgets.formpopup.colortitle.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3043PickMeta extends FieldMetaBuilder<MyEntity3043PickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3043PickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3043PickDTO_.id);
        fields.setEnabled(MyEntity3043PickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3043PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
