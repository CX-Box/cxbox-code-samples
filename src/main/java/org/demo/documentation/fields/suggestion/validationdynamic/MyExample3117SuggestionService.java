package org.demo.documentation.fields.suggestion.validationdynamic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3117SuggestionService extends AnySourceVersionAwareResponseService<MyExample3117SuggestionDTO, MyEntity3117OutServiceDTO> {


    public MyExample3117SuggestionService() {
        super(MyExample3117SuggestionDTO.class, MyEntity3117OutServiceDTO.class, MyExample3117SuggestionMeta.class, MyEntity3117Dao.class);
    }


    @Override
    protected CreateResult<MyExample3117SuggestionDTO> doCreateEntity(MyEntity3117OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3117SuggestionDTO> doUpdateEntity(MyEntity3117OutServiceDTO entity, MyExample3117SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3117SuggestionDTO> getActions() {
        return Actions.<MyExample3117SuggestionDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }


}