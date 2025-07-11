package org.demo.documentation.fields.suggestion.validationannotation;

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
public class MyExample3110SuggestionService extends AnySourceVersionAwareResponseService<MyExample3110SuggestionDTO, MyEntity3110OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3110SuggestionMeta> meta = MyExample3110SuggestionMeta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3110Dao> dao = MyEntity3110Dao.class;


    @Override
    protected CreateResult<MyExample3110SuggestionDTO> doCreateEntity(MyEntity3110OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3110SuggestionDTO> doUpdateEntity(MyEntity3110OutServiceDTO entity, MyExample3110SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3110SuggestionDTO> getActions() {
        return Actions.<MyExample3110SuggestionDTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }

     // --8<-- [end:getActions]  
}