package org.demo.documentation.widgets.list.showcondition.bycurrententity;

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
public class MyExample3101Service extends VersionAwareResponseService<MyExample3101DTO, MyEntity3101> {

    private final MyEntity3101Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3101Meta> meta = MyExample3101Meta.class;

    @Override
    protected CreateResult<MyExample3101DTO> doCreateEntity(MyEntity3101 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3101DTO> doUpdateEntity(MyEntity3101 entity, MyExample3101DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3101DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3101DTO> getActions() {
        return Actions.<MyExample3101DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}