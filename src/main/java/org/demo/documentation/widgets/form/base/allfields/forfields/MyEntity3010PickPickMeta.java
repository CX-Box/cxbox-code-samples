package org.demo.documentation.widgets.form.base.allfields.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3010PickPickMeta extends FieldMetaBuilder<MyEntity3010PickPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3010PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010PickPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010PickPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3010PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
