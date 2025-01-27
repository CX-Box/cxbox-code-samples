package org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.picklist;

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
public class MyEntity3092PickPickService extends VersionAwareResponseService<MyEntity3092PickPickDTO, MyEntity3092Pick> {
    private final MyEntity3092PickRepository repository;

    public MyEntity3092PickPickService(MyEntity3092PickRepository repository) {
        super(MyEntity3092PickPickDTO.class, MyEntity3092Pick.class, null, MyEntity3092PickPickMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3092PickPickDTO> doCreateEntity(MyEntity3092Pick entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyEntity3092PickPickDTO> doUpdateEntity(MyEntity3092Pick entity, MyEntity3092PickPickDTO data,
                                                                      BusinessComponent bc) {
        setIfChanged(data, MyEntity3092PickPickDTO_.customField, entity::setCustomField);
        repository.save(entity);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3092PickPickDTO> getActions() {
        return Actions.<MyEntity3092PickPickDTO>builder()
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .build();
    }
    // --8<-- [end:getActions]

}