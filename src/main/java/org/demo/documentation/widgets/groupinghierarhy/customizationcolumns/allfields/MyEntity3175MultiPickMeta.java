package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3175MultiPickMeta extends FieldMetaBuilder<MyEntity3175MultiPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3175MultiPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175MultiPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175MultiPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3175MultiPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
