package org.demo.documentation.widgets.assoc.colortitle.allfields.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3052PicklistAssocPickMeta extends FieldMetaBuilder<MyEntity3052PicklistAssocPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3052PicklistAssocPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3052PicklistAssocPickDTO_.id);
        fields.setEnabled(MyEntity3052PicklistAssocPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3052PicklistAssocPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
