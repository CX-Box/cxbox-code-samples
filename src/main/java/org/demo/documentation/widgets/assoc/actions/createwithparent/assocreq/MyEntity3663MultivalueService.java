package org.demo.documentation.widgets.assoc.actions.createwithparent.assocreq;

import lombok.Getter;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3663MultivalueService extends VersionAwareResponseService<MyEntity3663MultivalueDTO, MyEntity3663> {
    private final MyEntity3663MultiRepository repository;

    public MyEntity3663MultivalueService(MyEntity3663MultiRepository repository) {
        super(MyEntity3663MultivalueDTO.class, MyEntity3663.class, null, MyEntity3663MultivalueMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3663MultivalueDTO> doCreateEntity(MyEntity3663 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3663MultivalueDTO> doUpdateEntity(MyEntity3663 entity, MyEntity3663MultivalueDTO data,
                                                                        BusinessComponent bc) {
        setIfChanged(data, MyEntity3663MultivalueDTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


    @Override
    public ActionResultDTO<MyEntity3663MultivalueDTO> deleteEntity(BusinessComponent bc) {
        ActionResultDTO<MyEntity3663MultivalueDTO> contactDTOActionResultDTO;
        try {
            contactDTOActionResultDTO = super.deleteEntity(bc);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(e).addPopup("You are trying to delete row, that is referenced from other place in system. Deletion is not available");
        }
        return contactDTOActionResultDTO;
    }

    @Override
    public Actions<MyEntity3663MultivalueDTO> getActions() {
        return Actions.<MyEntity3663MultivalueDTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }
}