package org.demo.documentation.fields.suggestion.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3119SuggestionService extends AnySourceVersionAwareResponseService<MyExample3119SuggestionDTO, MyEntity3119OutServiceDTO> {


    public MyExample3119SuggestionService() {
        super(MyExample3119SuggestionDTO.class, MyEntity3119OutServiceDTO.class, MyExample3119SuggestionMeta.class, MyEntity3119Dao.class);
    }


    @Override
    protected CreateResult<MyExample3119SuggestionDTO> doCreateEntity(MyEntity3119OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3119SuggestionDTO> doUpdateEntity(MyEntity3119OutServiceDTO entity, MyExample3119SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3119SuggestionDTO> getActions() {
        return Actions.<MyExample3119SuggestionDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

     // --8<-- [end:getActions]  
}