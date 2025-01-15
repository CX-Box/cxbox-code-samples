package org.demo.documentation.widgets.formpopup.base.onefield.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3400InlinePicklistPickMeta extends FieldMetaBuilder<MyEntity3400InlinePicklistPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3400InlinePicklistPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.formpopup.base.onefield.MyEntity3400InlinePicklistPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.formpopup.base.onefield.MyEntity3400InlinePicklistPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3400InlinePicklistPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
