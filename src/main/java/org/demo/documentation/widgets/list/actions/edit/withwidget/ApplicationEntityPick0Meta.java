package org.demo.documentation.widgets.list.actions.edit.withwidget;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class ApplicationEntityPick0Meta extends FieldMetaBuilder<ApplicationEntityPick0DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<ApplicationEntityPick0DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.widgets.list.actions.edit.withwidget.ApplicationEntityPick0DTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.list.actions.edit.withwidget.ApplicationEntityPick0DTO_.name);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<ApplicationEntityPick0DTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
