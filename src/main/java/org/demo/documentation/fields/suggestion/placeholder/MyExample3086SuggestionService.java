package org.demo.documentation.fields.suggestion.placeholder;

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
public class MyExample3086SuggestionService extends AnySourceVersionAwareResponseService<MyExample3086SuggestionDTO, MyEntity3086OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3086SuggestionMeta> meta = MyExample3086SuggestionMeta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3086Dao> dao = MyEntity3086Dao.class;


    @Override
    protected CreateResult<MyExample3086SuggestionDTO> doCreateEntity(MyEntity3086OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3086SuggestionDTO> doUpdateEntity(MyEntity3086OutServiceDTO entity, MyExample3086SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3086SuggestionDTO> getActions() {
        return Actions.<MyExample3086SuggestionDTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }

     // --8<-- [end:getActions]  
}