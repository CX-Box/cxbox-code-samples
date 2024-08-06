package org.demo.documentation.fields.suggestion.validationbusinessex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3112SuggestionService extends AnySourceVersionAwareResponseService<MyExample3112SuggestionDTO, MyEntity3112OutServiceDTO> {


    public MyExample3112SuggestionService() {
        super(MyExample3112SuggestionDTO.class, MyEntity3112OutServiceDTO.class, MyExample3112SuggestionMeta.class, MyEntity3112Dao.class);
    }


    @Override
    protected CreateResult<MyExample3112SuggestionDTO> doCreateEntity(MyEntity3112OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3112SuggestionDTO> doUpdateEntity(MyEntity3112OutServiceDTO entity, MyExample3112SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3112SuggestionDTO> getActions() {
        return Actions.<MyExample3112SuggestionDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }


}