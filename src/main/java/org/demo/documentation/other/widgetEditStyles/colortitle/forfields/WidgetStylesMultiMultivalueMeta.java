package org.demo.documentation.other.widgetEditStyles.colortitle.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050MultiMultivalueDTO_;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class WidgetStylesMultiMultivalueMeta extends FieldMetaBuilder<WidgetStylesMultiMultivalueDTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<WidgetStylesMultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
        fields.setEnabled(WidgetStylesMultiMultivalueDTO_.id);
        fields.setEnabled(WidgetStylesMultiMultivalueDTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<WidgetStylesMultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

    }

}
