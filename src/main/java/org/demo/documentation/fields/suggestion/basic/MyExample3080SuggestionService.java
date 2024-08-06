package org.demo.documentation.fields.suggestion.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3080SuggestionService extends AnySourceVersionAwareResponseService<MyExample3080SuggestionDTO, MyEntity3080OutServiceDTO> {


    public MyExample3080SuggestionService() {
        super(MyExample3080SuggestionDTO.class, MyEntity3080OutServiceDTO.class, MyExample3080SuggestionMeta.class, MyEntity3080Dao.class);
    }


    @Override
    protected CreateResult<MyExample3080SuggestionDTO> doCreateEntity(MyEntity3080OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3080SuggestionDTO> doUpdateEntity(MyEntity3080OutServiceDTO entity, MyExample3080SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3080SuggestionDTO> getActions() {
        return Actions.<MyExample3080SuggestionDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }


}