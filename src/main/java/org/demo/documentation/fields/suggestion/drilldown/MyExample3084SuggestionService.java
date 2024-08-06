package org.demo.documentation.fields.suggestion.drilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;


@Service
public class MyExample3084SuggestionService extends AnySourceVersionAwareResponseService<MyExample3084SuggestionDTO, MyEntity3084OutServiceDTO> {


    public MyExample3084SuggestionService() {
        super(MyExample3084SuggestionDTO.class, MyEntity3084OutServiceDTO.class, MyExample3084SuggestionMeta.class, MyEntity3084Dao.class);
    }


    @Override
    protected CreateResult<MyExample3084SuggestionDTO> doCreateEntity(MyEntity3084OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3084SuggestionDTO> doUpdateEntity(MyEntity3084OutServiceDTO entity, MyExample3084SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3084SuggestionDTO> getActions() {
        return Actions.<MyExample3084SuggestionDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }


}