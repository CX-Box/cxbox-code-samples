package org.demo.documentation.fields.suggestion.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3114SuggestionService extends AnySourceVersionAwareResponseService<MyExample3114SuggestionDTO, MyEntity3114OutServiceDTO> {


    public MyExample3114SuggestionService() {
        super(MyExample3114SuggestionDTO.class, MyEntity3114OutServiceDTO.class, MyExample3114SuggestionMeta.class, MyEntity3114Dao.class);
    }


    @Override
    protected CreateResult<MyExample3114SuggestionDTO> doCreateEntity(MyEntity3114OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3114SuggestionDTO> doUpdateEntity(MyEntity3114OutServiceDTO entity, MyExample3114SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3114SuggestionDTO> getActions() {
        return Actions.<MyExample3114SuggestionDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

     // --8<-- [end:getActions]  
}