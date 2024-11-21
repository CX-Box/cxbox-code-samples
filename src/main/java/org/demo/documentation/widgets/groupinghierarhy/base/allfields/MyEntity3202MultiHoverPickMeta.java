package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3202MultiHoverPickMeta extends FieldMetaBuilder<MyEntity3202MultiHoverPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3202MultiHoverPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.groupinghierarhy.base.allfields.MyEntity3202MultiHoverPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.groupinghierarhy.base.allfields.MyEntity3202MultiHoverPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3202MultiHoverPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
