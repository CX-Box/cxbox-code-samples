package org.demo.documentation.multivalue.primary;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity2001MultivalueMeta extends FieldMetaBuilder<MyEntity2001MultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity2001MultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.multivalue.primary.MyEntity2001MultivalueDTO_.id);
        fields.setEnabled(org.demo.documentation.multivalue.primary.MyEntity2001MultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity2001MultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
