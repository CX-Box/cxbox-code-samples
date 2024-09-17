package org.demo.documentation.widgets.assoc.actions.buttonassoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3062MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3062MultiMultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3062MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.assoc.actions.buttonassoc.MyEntity3062MultiMultivalueDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.assoc.actions.buttonassoc.MyEntity3062MultiMultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3062MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableSort(MyEntity3062MultiMultivalueDTO_.id);
        fields.enableSort(MyEntity3062MultiMultivalueDTO_.customField);

    }

}
