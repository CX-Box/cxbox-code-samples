package org.demo.documentation.widgets.assoc.actions.createwithparent.assoc;

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
public class MyEntity3662MultivalueService extends VersionAwareResponseService<MyEntity3662MultivalueDTO, MyEntity3662> {
    private final MyEntity3662MultiRepository repository;

    public MyEntity3662MultivalueService(MyEntity3662MultiRepository repository) {
        super(MyEntity3662MultivalueDTO.class, MyEntity3662.class, null, MyEntity3662MultivalueMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3662MultivalueDTO> doCreateEntity(MyEntity3662 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3662MultivalueDTO> doUpdateEntity(MyEntity3662 entity, MyEntity3662MultivalueDTO data,
                                                                        BusinessComponent bc) {
        setIfChanged(data, MyEntity3662MultivalueDTO_.customField, entity::setCustomField);
        setIfChanged(data, MyEntity3662MultivalueDTO_.customFieldText, entity::setCustomFieldText);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public ActionResultDTO<MyEntity3662MultivalueDTO> deleteEntity(BusinessComponent bc) {
        ActionResultDTO<MyEntity3662MultivalueDTO> contactDTOActionResultDTO;
        try {
            contactDTOActionResultDTO = super.deleteEntity(bc);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(e).addPopup("You are trying to delete row, that is referenced from other place in system. Deletion is not available");
        }
        return contactDTOActionResultDTO;
    }

    @Override
    public Actions<MyEntity3662MultivalueDTO> getActions() {
        return Actions.<MyEntity3662MultivalueDTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }
}