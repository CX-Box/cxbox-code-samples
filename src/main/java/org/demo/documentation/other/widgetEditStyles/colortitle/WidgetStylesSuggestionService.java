package org.demo.documentation.other.widgetEditStyles.colortitle;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class WidgetStylesSuggestionService extends AnySourceVersionAwareResponseService<WidgetStylesSuggestionDTO, WidgetStylesOutServiceDTO> {


    public WidgetStylesSuggestionService() {
        super(WidgetStylesSuggestionDTO.class, WidgetStylesOutServiceDTO.class, WidgetStylesSuggestionMeta.class, WidgetStylesDao.class);
    }


    @Override
    protected CreateResult<WidgetStylesSuggestionDTO> doCreateEntity(WidgetStylesOutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<WidgetStylesSuggestionDTO> doUpdateEntity(WidgetStylesOutServiceDTO entity, WidgetStylesSuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<WidgetStylesSuggestionDTO> getActions() {
        return Actions.<WidgetStylesSuggestionDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

     // --8<-- [end:getActions]  
}