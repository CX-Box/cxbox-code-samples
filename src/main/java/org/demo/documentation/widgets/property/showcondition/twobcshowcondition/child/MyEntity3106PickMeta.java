package org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3106PickMeta extends FieldMetaBuilder<MyEntity3106PickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3106PickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child.MyEntity3106PickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child.MyEntity3106PickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3106PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
