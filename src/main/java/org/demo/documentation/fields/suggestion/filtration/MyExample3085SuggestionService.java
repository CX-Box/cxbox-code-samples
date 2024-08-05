package org.demo.documentation.fields.suggestion.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.suggestion.basic.MyEntity3085Dao;
import org.springframework.stereotype.Service;


@Service
public class MyExample3085SuggestionService extends AnySourceVersionAwareResponseService<MyExample3085SuggestionDTO, MyEntity3085OutServiceDTO> {


    public MyExample3085SuggestionService() {
        super(MyExample3085SuggestionDTO.class, MyEntity3085OutServiceDTO.class, MyExample3085SuggestionMeta.class, MyEntity3085Dao.class);
    }


    @Override
    protected CreateResult<MyExample3085SuggestionDTO> doCreateEntity(MyEntity3085OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3085SuggestionDTO> doUpdateEntity(MyEntity3085OutServiceDTO entity, MyExample3085SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3085SuggestionDTO> getActions() {
        return Actions.<MyExample3085SuggestionDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }


}