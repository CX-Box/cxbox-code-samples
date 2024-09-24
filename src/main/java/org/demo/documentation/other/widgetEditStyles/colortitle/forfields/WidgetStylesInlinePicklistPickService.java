package org.demo.documentation.other.widgetEditStyles.colortitle.forfields;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class WidgetStylesInlinePicklistPickService extends VersionAwareResponseService<WidgetStylesInlinePicklistPickDTO, WidgetStylesInlinePicklist> {

    public WidgetStylesInlinePicklistPickService() {
        super(WidgetStylesInlinePicklistPickDTO.class, WidgetStylesInlinePicklist.class, null, WidgetStylesInlinePicklistPickMeta.class);
    }

    @Override
    protected CreateResult<WidgetStylesInlinePicklistPickDTO> doCreateEntity(WidgetStylesInlinePicklist entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<WidgetStylesInlinePicklistPickDTO> doUpdateEntity(WidgetStylesInlinePicklist entity, WidgetStylesInlinePicklistPickDTO data,
                                                                                BusinessComponent bc) {
        return null;
    }


}