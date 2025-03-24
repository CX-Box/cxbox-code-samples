package org.demo.documentation.fields.suggestion.color.colorcalc;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;


@Service
public class MyExample3082SuggestionService extends AnySourceVersionAwareResponseService<MyExample3082SuggestionDTO, MyEntity3082OutServiceDTO> {


    public MyExample3082SuggestionService() {
        super(MyExample3082SuggestionDTO.class, MyEntity3082OutServiceDTO.class, MyExample3082Meta.class, MyEntity3082Dao.class);
    }


    @Override
    protected CreateResult<MyExample3082SuggestionDTO> doCreateEntity(MyEntity3082OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3082SuggestionDTO> doUpdateEntity(MyEntity3082OutServiceDTO entity, MyExample3082SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3082SuggestionDTO> getActions() {
        return Actions.<MyExample3082SuggestionDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }

     // --8<-- [end:getActions]  
}