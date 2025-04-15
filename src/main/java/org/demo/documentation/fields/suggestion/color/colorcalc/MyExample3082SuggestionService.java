package org.demo.documentation.fields.suggestion.color.colorcalc;

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
public class MyExample3082SuggestionService extends AnySourceVersionAwareResponseService<MyExample3082SuggestionDTO, MyEntity3082OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3082Meta> meta = MyExample3082Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3082Dao> dao = MyEntity3082Dao.class;


    @Override
    protected CreateResult<MyExample3082SuggestionDTO> doCreateEntity(MyEntity3082OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3082SuggestionDTO> doUpdateEntity(MyEntity3082OutServiceDTO entity, MyExample3082SuggestionDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3082SuggestionDTO> getActions() {
        return Actions.<MyExample3082SuggestionDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }

     // --8<-- [end:getActions]  
}