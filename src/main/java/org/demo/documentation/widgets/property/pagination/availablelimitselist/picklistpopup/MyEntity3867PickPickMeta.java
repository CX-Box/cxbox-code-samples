package org.demo.documentation.widgets.property.pagination.availablelimitselist.picklistpopup;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3867PickPickMeta extends FieldMetaBuilder<MyEntity3867PickPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3867PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3867PickPickDTO_.id);
        fields.setEnabled(MyEntity3867PickPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3867PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
