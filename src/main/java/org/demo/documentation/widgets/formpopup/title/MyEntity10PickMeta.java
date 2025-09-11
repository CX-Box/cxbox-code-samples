package org.demo.documentation.widgets.formpopup.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity10PickMeta extends FieldMetaBuilder<MyEntity10PickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity10PickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.formpopup.title.MyEntity10PickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.formpopup.title.MyEntity10PickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity10PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
