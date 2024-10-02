package org.demo.documentation.fields.suggestion.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;


@Service
public class MyExample3088SuggestionService extends AnySourceVersionAwareResponseService<MyExample3088SuggestionDTO, MyEntity3088OutServiceDTO> {


    public MyExample3088SuggestionService() {
        super(MyExample3088SuggestionDTO.class, MyEntity3088OutServiceDTO.class, MyExample3088SuggestionMeta.class, MyEntity3088Dao.class);
    }


    @Override
    protected CreateResult<MyExample3088SuggestionDTO> doCreateEntity(MyEntity3088OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3088SuggestionDTO> doUpdateEntity(MyEntity3088OutServiceDTO entity, MyExample3088SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3088SuggestionDTO> getActions() {
        return Actions.<MyExample3088SuggestionDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

     // --8<-- [end:getActions]  
}