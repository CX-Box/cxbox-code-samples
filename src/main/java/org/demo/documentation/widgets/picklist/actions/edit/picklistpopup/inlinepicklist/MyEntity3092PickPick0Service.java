package org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.inlinepicklist;

import lombok.Getter;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.MyEntity3092Pick;
import org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.MyEntity3092PickRepository;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3092PickPick0Service extends VersionAwareResponseService<MyEntity3092PickPick0DTO, MyEntity3092Pick> {
    private final MyEntity3092PickRepository repository;

    public MyEntity3092PickPick0Service(MyEntity3092PickRepository repository) {
        super(MyEntity3092PickPick0DTO.class, MyEntity3092Pick.class, null, MyEntity3092PickPick0Meta.class);
        this.repository = repository;
    }

    // --8<-- [start:doCreateEntity]
    @Override
    protected CreateResult<MyEntity3092PickPick0DTO> doCreateEntity(MyEntity3092Pick entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doCreateEntity]

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyEntity3092PickPick0DTO> doUpdateEntity(MyEntity3092Pick entity, MyEntity3092PickPick0DTO data,
                                                                       BusinessComponent bc) {
        setIfChanged(data, MyEntity3092PickPick0DTO_.customField, entity::setCustomField);
        repository.save(entity);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3092PickPick0DTO> getActions() {
        return Actions.<MyEntity3092PickPick0DTO>builder()
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .build();
    }
    // --8<-- [end:getActions]
}
