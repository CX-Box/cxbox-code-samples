package org.demo.documentation.widgets.list.actions.edit.withwidget;

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
        fields.setEnabled(MyEntity10PickDTO_.dfgdfgdId);
        fields.setEnabled(MyEntity10PickDTO_.dfgdfgd);
        fields.setEnabled(MyEntity10PickDTO_.customFieldText);
        fields.setEnabled(org.demo.documentation.widgets.list.actions.edit.withwidget.MyEntity10PickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.list.actions.edit.withwidget.MyEntity10PickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity10PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableFilter(MyEntity10PickDTO_.dfgdfgd);
        fields.enableFilter(MyEntity10PickDTO_.customFieldText);

    }

}
