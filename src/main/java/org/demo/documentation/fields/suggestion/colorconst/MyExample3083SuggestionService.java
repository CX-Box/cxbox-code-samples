package org.demo.documentation.fields.suggestion.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;


@Service
public class MyExample3083SuggestionService extends AnySourceVersionAwareResponseService<MyExample3083SuggestionDTO, MyEntity3083OutServiceDTO> {


    public MyExample3083SuggestionService() {
        super(MyExample3083SuggestionDTO.class, MyEntity3083OutServiceDTO.class, MyExample3083SuggestionMeta.class, MyEntity3083Dao.class);
    }


    @Override
    protected CreateResult<MyExample3083SuggestionDTO> doCreateEntity(MyEntity3083OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3083SuggestionDTO> doUpdateEntity(MyEntity3083OutServiceDTO entity, MyExample3083SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3083SuggestionDTO> getActions() {
        return Actions.<MyExample3083SuggestionDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }


}