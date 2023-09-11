package org.demo.documentation.other.alltypes;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity424MultivalueMeta extends FieldMetaBuilder<MyEntity424MultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity424MultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.other.alltypes.MyEntity424MultivalueDTO_.id);
        fields.setEnabled(org.demo.documentation.other.alltypes.MyEntity424MultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity424MultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
