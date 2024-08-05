package org.demo.documentation.fields.suggestion.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.suggestion.basic.MyEntity3087Dao;
import org.springframework.stereotype.Service;


@Service
public class MyExample3087SuggestionService extends AnySourceVersionAwareResponseService<MyExample3087SuggestionDTO, MyEntity3087OutServiceDTO> {


    public MyExample3087SuggestionService() {
        super(MyExample3087SuggestionDTO.class, MyEntity3087OutServiceDTO.class, MyExample3087SuggestionMeta.class, MyEntity3087Dao.class);
    }


    @Override
    protected CreateResult<MyExample3087SuggestionDTO> doCreateEntity(MyEntity3087OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3087SuggestionDTO> doUpdateEntity(MyEntity3087OutServiceDTO entity, MyExample3087SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3087SuggestionDTO> getActions() {
        return Actions.<MyExample3087SuggestionDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }


}