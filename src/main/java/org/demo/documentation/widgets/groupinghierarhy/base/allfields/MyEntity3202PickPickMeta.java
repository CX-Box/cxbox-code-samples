package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3202PickPickMeta extends FieldMetaBuilder<MyEntity3202PickPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3202PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.groupinghierarhy.base.allfields.MyEntity3202PickPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.groupinghierarhy.base.allfields.MyEntity3202PickPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3202PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
