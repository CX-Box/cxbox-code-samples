package org.demo.documentation.widgets.assoc.actions.create;

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
public class MyEntity3054MultiMultivalueService extends VersionAwareResponseService<MyEntity3054MultiMultivalueDTO, MyEntity3054Multi> {
    private final MyEntity3054MultiRepository repository;

    public MyEntity3054MultiMultivalueService(MyEntity3054MultiRepository repository) {
        super(MyEntity3054MultiMultivalueDTO.class, MyEntity3054Multi.class, null, MyEntity3054MultiMultivalueMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3054MultiMultivalueDTO> doCreateEntity(MyEntity3054Multi entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3054MultiMultivalueDTO> doUpdateEntity(MyEntity3054Multi entity, MyEntity3054MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        repository.save(entity);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public ActionResultDTO<MyEntity3054MultiMultivalueDTO> deleteEntity(BusinessComponent bc) {
        ActionResultDTO<MyEntity3054MultiMultivalueDTO> contactDTOActionResultDTO;
        try {
            contactDTOActionResultDTO = super.deleteEntity(bc);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(e).addPopup("You are trying to delete row, that is referenced from other place in system. Deletion is not available");
        }
        return contactDTOActionResultDTO;
    }

    @Override
    public Actions<MyEntity3054MultiMultivalueDTO> getActions() {
        return Actions.<MyEntity3054MultiMultivalueDTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }
}