package org.demo.documentation.widgets.assoc.actions.create;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3054MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3054MultiMultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3054MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.assoc.actions.create.MyEntity3054MultiMultivalueDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.assoc.actions.create.MyEntity3054MultiMultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3054MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}