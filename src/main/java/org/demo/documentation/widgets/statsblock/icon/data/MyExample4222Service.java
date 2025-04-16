package org.demo.documentation.widgets.statsblock.icon.data;

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
public class MyExample4222Service extends VersionAwareResponseService<MyExample4222DTO, MyEntity4222> {

    private final MyEntity4222Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4222Meta> meta = MyExample4222Meta.class;

    @Override
    protected CreateResult<MyExample4222DTO> doCreateEntity(MyEntity4222 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4222DTO> doUpdateEntity(MyEntity4222 entity, MyExample4222DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4222DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4222DTO> getActions() {
        return Actions.<MyExample4222DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}