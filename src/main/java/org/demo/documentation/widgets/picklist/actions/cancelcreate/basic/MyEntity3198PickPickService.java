package org.demo.documentation.widgets.picklist.actions.cancelcreate.basic;

import lombok.Getter;

import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3198PickPickService extends VersionAwareResponseService<MyEntity3198PickPickDTO, MyEntity3198Pick> {
    private final MyEntity3198PickRepository repository;

    public MyEntity3198PickPickService(MyEntity3198PickRepository repository) {
        super(MyEntity3198PickPickDTO.class, MyEntity3198Pick.class, null, MyEntity3198PickPickMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3198PickPickDTO> doCreateEntity(MyEntity3198Pick entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3198PickPickDTO> doUpdateEntity(MyEntity3198Pick entity, MyEntity3198PickPickDTO data,
                                                                      BusinessComponent bc) {
        setIfChanged(data, MyEntity3198PickPickDTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
}
    // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3198PickPickDTO> getActions() {
        return Actions.<MyEntity3198PickPickDTO>builder()
                .create(crt -> crt.text("Add"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .build();
    }
    // --8<-- [end:getActions]

}