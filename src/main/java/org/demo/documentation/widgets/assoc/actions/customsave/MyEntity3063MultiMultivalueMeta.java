package org.demo.documentation.widgets.assoc.actions.customsave;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3063MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3063MultiMultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3063MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.assoc.actions.customsave.MyEntity3063MultiMultivalueDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.assoc.actions.customsave.MyEntity3063MultiMultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3063MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableSort(org.demo.documentation.widgets.assoc.actions.customsave.MyEntity3063MultiMultivalueDTO_.id);
        fields.enableSort(org.demo.documentation.widgets.assoc.actions.customsave.MyEntity3063MultiMultivalueDTO_.customField);

    }

}
