package org.demo.documentation.widgets.assoc.colortitle.allfields.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3052MultiAssocMultivalueMeta extends FieldMetaBuilder<MyEntity3052MultiAssocMultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3052MultiAssocMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3052MultiAssocMultivalueDTO_.id);
        fields.setEnabled(MyEntity3052MultiAssocMultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3052MultiAssocMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
