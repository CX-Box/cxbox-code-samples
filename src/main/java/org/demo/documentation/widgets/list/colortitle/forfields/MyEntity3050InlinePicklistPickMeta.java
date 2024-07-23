package org.demo.documentation.widgets.list.colortitle.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3050InlinePicklistPickMeta extends FieldMetaBuilder<MyEntity3050InlinePicklistPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3050InlinePicklistPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3050InlinePicklistPickDTO_.id);
        fields.setEnabled(MyEntity3050InlinePicklistPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3050InlinePicklistPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
