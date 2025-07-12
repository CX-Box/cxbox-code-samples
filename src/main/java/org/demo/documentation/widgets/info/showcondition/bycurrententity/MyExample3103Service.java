package org.demo.documentation.widgets.info.showcondition.bycurrententity;

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
public class MyExample3103Service extends VersionAwareResponseService<MyExample3103DTO, MyEntity3103> {

    private final MyEntity3103Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3103Meta> meta = MyExample3103Meta.class;

    @Override
    protected CreateResult<MyExample3103DTO> doCreateEntity(MyEntity3103 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3103DTO> doUpdateEntity(MyEntity3103 entity, MyExample3103DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3103DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3103DTO> getActions() {
        return Actions.<MyExample3103DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}