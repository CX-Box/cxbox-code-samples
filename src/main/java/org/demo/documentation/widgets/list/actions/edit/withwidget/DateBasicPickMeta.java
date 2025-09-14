package org.demo.documentation.widgets.list.actions.edit.withwidget;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class DateBasicPickMeta extends FieldMetaBuilder<DateBasicPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<DateBasicPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.list.actions.edit.withwidget.DateBasicPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.list.actions.edit.withwidget.DateBasicPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<DateBasicPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
