package org.demo.documentation.other.widgetEditStyles.colortitle;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class WidgetStylesSuggestionMeta extends AnySourceFieldMetaBuilder<WidgetStylesSuggestionDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<WidgetStylesSuggestionDTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<WidgetStylesSuggestionDTO> fields, BcDescription bcDescription, String parentId) {
    }

}
