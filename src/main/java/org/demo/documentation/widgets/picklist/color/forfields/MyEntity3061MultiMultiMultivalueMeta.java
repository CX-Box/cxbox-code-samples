package org.demo.documentation.widgets.picklist.color.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3061MultiMultiMultivalueMeta extends FieldMetaBuilder<MyEntity3061MultiMultiMultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3061MultiMultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3061MultiMultiMultivalueDTO_.id);
        fields.setEnabled(MyEntity3061MultiMultiMultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3061MultiMultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
