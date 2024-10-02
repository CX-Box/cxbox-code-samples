package org.demo.documentation.widgets.picklist.actions.create.picklist;

import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Service
public class MyEntity3072PickPickService extends VersionAwareResponseService<MyEntity3072PickPickDTO, MyEntity3072Pick> {
    private final MyEntity3072PickRepository repository;

    public MyEntity3072PickPickService(MyEntity3072PickRepository repository) {
        super(MyEntity3072PickPickDTO.class, MyEntity3072Pick.class, null, MyEntity3072PickPickMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3072PickPickDTO> doCreateEntity(MyEntity3072Pick entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3072PickPickDTO> doUpdateEntity(MyEntity3072Pick entity, MyEntity3072PickPickDTO data,
                                                                      BusinessComponent bc) {
        setIfChanged(data, MyEntity3072PickPickDTO_.customFieldPick, entity::setCustomFieldPick);
        repository.save(entity);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public ActionResultDTO<MyEntity3072PickPickDTO> deleteEntity(BusinessComponent bc) {
        ActionResultDTO<MyEntity3072PickPickDTO> contactDTOActionResultDTO;
        try {
            contactDTOActionResultDTO = super.deleteEntity(bc);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(e).addPopup("You are trying to delete row, that is referenced from other place in system. Deletion is not available");
        }
        return contactDTOActionResultDTO;
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3072PickPickDTO> getActions() {
        return Actions.<MyEntity3072PickPickDTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }
}

