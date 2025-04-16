package org.demo.documentation.fields.time.validationconfirm;

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
public class MyExample4103Service extends VersionAwareResponseService<MyExample4103DTO, MyEntity4103> {

    private final MyEntity4103Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4103Meta> meta = MyExample4103Meta.class;

    @Override
    protected CreateResult<MyExample4103DTO> doCreateEntity(MyEntity4103 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4103DTO> doUpdateEntity(MyEntity4103 entity, MyExample4103DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4103DTO> getActions() {
        return Actions.<MyExample4103DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}