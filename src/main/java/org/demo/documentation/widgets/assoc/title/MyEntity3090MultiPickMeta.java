package org.demo.documentation.widgets.assoc.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3090MultiPickMeta extends FieldMetaBuilder<MyEntity3090MultiPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3090MultiPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.assoc.title.MyEntity3090MultiPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.assoc.title.MyEntity3090MultiPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3090MultiPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
