package org.demo.documentation.other.alltypes;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity422MultivalueMeta extends FieldMetaBuilder<MyEntity422MultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity422MultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.other.alltypes.MyEntity422MultivalueDTO_.id);
        fields.setEnabled(org.demo.documentation.other.alltypes.MyEntity422MultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity422MultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
