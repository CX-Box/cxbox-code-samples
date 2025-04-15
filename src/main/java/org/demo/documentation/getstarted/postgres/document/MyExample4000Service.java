package org.demo.documentation.getstarted.postgres.document;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4000Service extends VersionAwareResponseService<MyExample4000DTO, MyEntity4000> {

    private final MyEntity4000Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4000Meta> meta = MyExample4000Meta.class;

    @Override
    protected CreateResult<MyExample4000DTO> doCreateEntity(MyEntity4000 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4000DTO> doUpdateEntity(MyEntity4000 entity, MyExample4000DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4000DTO> getActions() {
        return Actions.<MyExample4000DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}