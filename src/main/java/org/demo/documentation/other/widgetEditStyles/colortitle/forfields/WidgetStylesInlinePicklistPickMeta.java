package org.demo.documentation.other.widgetEditStyles.colortitle.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050InlinePicklistPickDTO_;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class WidgetStylesInlinePicklistPickMeta extends FieldMetaBuilder<WidgetStylesInlinePicklistPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<WidgetStylesInlinePicklistPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
        fields.setEnabled(WidgetStylesInlinePicklistPickDTO_.id);
        fields.setEnabled(WidgetStylesInlinePicklistPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<WidgetStylesInlinePicklistPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

    }

}
