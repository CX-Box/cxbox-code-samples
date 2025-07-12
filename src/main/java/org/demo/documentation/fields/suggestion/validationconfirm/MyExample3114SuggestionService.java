package org.demo.documentation.fields.suggestion.validationconfirm;

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
public class MyExample3114SuggestionService extends AnySourceVersionAwareResponseService<MyExample3114SuggestionDTO, MyEntity3114OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3114SuggestionMeta> meta = MyExample3114SuggestionMeta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3114Dao> dao = MyEntity3114Dao.class;


    @Override
    protected CreateResult<MyExample3114SuggestionDTO> doCreateEntity(MyEntity3114OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3114SuggestionDTO> doUpdateEntity(MyEntity3114OutServiceDTO entity, MyExample3114SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3114SuggestionDTO> getActions() {
        return Actions.<MyExample3114SuggestionDTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }

     // --8<-- [end:getActions]  
}