package org.demo.documentation.widgets.list.actions.edit.withwidget;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity102PickMeta extends FieldMetaBuilder<MyEntity102PickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity102PickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.list.actions.edit.withwidget.MyEntity102PickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.list.actions.edit.withwidget.MyEntity102PickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity102PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
