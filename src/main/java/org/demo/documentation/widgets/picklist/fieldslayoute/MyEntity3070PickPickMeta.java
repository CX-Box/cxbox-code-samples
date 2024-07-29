package org.demo.documentation.widgets.picklist.fieldslayoute;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3070PickPickMeta extends FieldMetaBuilder<MyEntity3070PickPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3070PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.picklist.fieldslayoute.MyEntity3070PickPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.picklist.fieldslayoute.MyEntity3070PickPickDTO_.customFieldPick);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3070PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
