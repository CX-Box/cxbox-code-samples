package org.demo.documentation.getstarted.postgres.example;

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
public class MyExample4002Service extends VersionAwareResponseService<MyExample4002DTO, MyEntity4002> {

    private final MyEntity4002Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4002Meta> meta = MyExample4002Meta.class;

    @Override
    protected CreateResult<MyExample4002DTO> doCreateEntity(MyEntity4002 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4002DTO> doUpdateEntity(MyEntity4002 entity, MyExample4002DTO data, BusinessComponent bc) {

        if (data.isFieldChanged(MyExample4002DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4002DTO> getActions() {
        return Actions.<MyExample4002DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}