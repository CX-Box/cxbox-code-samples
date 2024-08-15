package org.demo.documentation.widgets.assoc.actions.createwithparent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3662MultivalueMeta extends FieldMetaBuilder<MyEntity3662MultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3662MultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3662MultivalueDTO_.customFieldText);
        fields.setRequired(MyEntity3662MultivalueDTO_.customFieldText);
        fields.setEnabled(org.demo.documentation.widgets.assoc.actions.createwithparent.MyEntity3662MultivalueDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.assoc.actions.createwithparent.MyEntity3662MultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3662MultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableFilter(MyEntity3662MultivalueDTO_.customFieldText);

    }

}
