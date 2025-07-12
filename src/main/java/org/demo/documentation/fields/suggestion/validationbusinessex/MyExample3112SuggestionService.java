package org.demo.documentation.fields.suggestion.validationbusinessex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample3112SuggestionService extends AnySourceVersionAwareResponseService<MyExample3112SuggestionDTO, MyEntity3112OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3112SuggestionMeta> meta = MyExample3112SuggestionMeta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3112Dao> dao = MyEntity3112Dao.class;


    @Override
    protected CreateResult<MyExample3112SuggestionDTO> doCreateEntity(MyEntity3112OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3112SuggestionDTO> doUpdateEntity(MyEntity3112OutServiceDTO entity, MyExample3112SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3112SuggestionDTO> getActions() {
        return Actions.<MyExample3112SuggestionDTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }

     // --8<-- [end:getActions]  
}