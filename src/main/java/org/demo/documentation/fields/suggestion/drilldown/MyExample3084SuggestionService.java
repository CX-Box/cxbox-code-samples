package org.demo.documentation.fields.suggestion.drilldown;

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
public class MyExample3084SuggestionService extends AnySourceVersionAwareResponseService<MyExample3084SuggestionDTO, MyEntity3084OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3084SuggestionMeta> meta = MyExample3084SuggestionMeta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3084Dao> dao = MyEntity3084Dao.class;


    @Override
    protected CreateResult<MyExample3084SuggestionDTO> doCreateEntity(MyEntity3084OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3084SuggestionDTO> doUpdateEntity(MyEntity3084OutServiceDTO entity, MyExample3084SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3084SuggestionDTO> getActions() {
        return Actions.<MyExample3084SuggestionDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }

     // --8<-- [end:getActions]  
}