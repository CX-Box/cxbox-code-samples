package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3202MultiPickMeta extends FieldMetaBuilder<MyEntity3202MultiPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3202MultiPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.groupinghierarhy.base.allfields.MyEntity3202MultiPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.groupinghierarhy.base.allfields.MyEntity3202MultiPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3202MultiPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
