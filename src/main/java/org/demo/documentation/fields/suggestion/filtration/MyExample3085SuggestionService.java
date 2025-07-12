package org.demo.documentation.fields.suggestion.filtration;

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
public class MyExample3085SuggestionService extends AnySourceVersionAwareResponseService<MyExample3085SuggestionDTO, MyEntity3085OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3085SuggestionMeta> meta = MyExample3085SuggestionMeta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3085Dao> dao = MyEntity3085Dao.class;


    @Override
    protected CreateResult<MyExample3085SuggestionDTO> doCreateEntity(MyEntity3085OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3085SuggestionDTO> doUpdateEntity(MyEntity3085OutServiceDTO entity, MyExample3085SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3085SuggestionDTO> getActions() {
        return Actions.<MyExample3085SuggestionDTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }

     // --8<-- [end:getActions]  
}