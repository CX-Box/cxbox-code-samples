package org.demo.documentation.other.widgetEditStyles.colortitle.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050MultiMultiMultivalueDTO_;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class WidgetStylesMultiMultiMultivalueMeta extends FieldMetaBuilder<WidgetStylesMultiMultiMultivalueDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<WidgetStylesMultiMultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
        fields.setEnabled(WidgetStylesMultiMultiMultivalueDTO_.id);
        fields.setEnabled(WidgetStylesMultiMultiMultivalueDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<WidgetStylesMultiMultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

    }

}