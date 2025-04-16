package org.demo.documentation.fields.suggestion.validationdynamic;

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
public class MyExample3117SuggestionService extends AnySourceVersionAwareResponseService<MyExample3117SuggestionDTO, MyEntity3117OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3117SuggestionMeta> meta = MyExample3117SuggestionMeta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3117Dao> dao = MyEntity3117Dao.class;


    @Override
    protected CreateResult<MyExample3117SuggestionDTO> doCreateEntity(MyEntity3117OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3117SuggestionDTO> doUpdateEntity(MyEntity3117OutServiceDTO entity, MyExample3117SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3117SuggestionDTO> getActions() {
        return Actions.<MyExample3117SuggestionDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }

     // --8<-- [end:getActions]  
}