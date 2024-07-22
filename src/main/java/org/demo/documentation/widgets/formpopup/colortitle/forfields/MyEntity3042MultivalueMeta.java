package org.demo.documentation.widgets.formpopup.colortitle.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3042MultivalueMeta extends FieldMetaBuilder<MyEntity3042MultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3042MultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3042MultivalueDTO_.id);
        fields.setEnabled(MyEntity3042MultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3042MultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
