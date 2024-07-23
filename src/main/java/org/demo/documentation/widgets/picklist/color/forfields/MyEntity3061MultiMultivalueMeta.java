package org.demo.documentation.widgets.picklist.color.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3061MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3061MultiMultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3061MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3061MultiMultivalueDTO_.id);
        fields.setEnabled(MyEntity3061MultiMultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3061MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
