package org.demo.documentation.fields.suggestion.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;


@Service
public class MyExample3086SuggestionService extends AnySourceVersionAwareResponseService<MyExample3086SuggestionDTO, MyEntity3086OutServiceDTO> {


    public MyExample3086SuggestionService() {
        super(MyExample3086SuggestionDTO.class, MyEntity3086OutServiceDTO.class, MyExample3086SuggestionMeta.class, MyEntity3086Dao.class);
    }


    @Override
    protected CreateResult<MyExample3086SuggestionDTO> doCreateEntity(MyEntity3086OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3086SuggestionDTO> doUpdateEntity(MyEntity3086OutServiceDTO entity, MyExample3086SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3086SuggestionDTO> getActions() {
        return Actions.<MyExample3086SuggestionDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }

     // --8<-- [end:getActions]  
}