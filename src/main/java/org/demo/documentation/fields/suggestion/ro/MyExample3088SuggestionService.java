package org.demo.documentation.fields.suggestion.ro;

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
public class MyExample3088SuggestionService extends AnySourceVersionAwareResponseService<MyExample3088SuggestionDTO, MyEntity3088OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3088SuggestionMeta> meta = MyExample3088SuggestionMeta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3088Dao> dao = MyEntity3088Dao.class;


    @Override
    protected CreateResult<MyExample3088SuggestionDTO> doCreateEntity(MyEntity3088OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3088SuggestionDTO> doUpdateEntity(MyEntity3088OutServiceDTO entity, MyExample3088SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3088SuggestionDTO> getActions() {
        return Actions.<MyExample3088SuggestionDTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }

     // --8<-- [end:getActions]  
}