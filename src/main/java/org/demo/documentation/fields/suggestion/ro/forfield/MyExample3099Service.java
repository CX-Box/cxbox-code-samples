package org.demo.documentation.fields.suggestion.ro.forfield;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3099Service extends VersionAwareResponseService<MyExample3099DTO, MyEntity3099> {

    private final MyEntity3099Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3099Meta> meta = MyExample3099Meta.class;

    @Override
    protected CreateResult<MyExample3099DTO> doCreateEntity(MyEntity3099 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3099DTO> doUpdateEntity(MyEntity3099 entity, MyExample3099DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3099DTO> getActions() {
        return Actions.<MyExample3099DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
