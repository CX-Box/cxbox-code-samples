package org.demo.documentation.widgets.assoc.actions.customsave;

import lombok.Getter;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.assoc.actions.other.customsave.MyEntity3063MultiMultivalueDTO_;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3063MultiMultivalueService extends VersionAwareResponseService<MyEntity3063MultiMultivalueDTO, MyEntity3063Multi> {
    private final MyEntity3063MultiRepository repository;

    public MyEntity3063MultiMultivalueService(MyEntity3063MultiRepository repository) {
        super(MyEntity3063MultiMultivalueDTO.class, MyEntity3063Multi.class, null, MyEntity3063MultiMultivalueMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3063MultiMultivalueDTO> doCreateEntity(MyEntity3063Multi entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3063MultiMultivalueDTO> doUpdateEntity(MyEntity3063Multi entity, MyEntity3063MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        setIfChanged(data, MyEntity3063MultiMultivalueDTO_.customFieldReq, entity::setCustomFieldReq);
        setIfChanged(data, MyEntity3063MultiMultivalueDTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public ActionResultDTO<MyEntity3063MultiMultivalueDTO> deleteEntity(BusinessComponent bc) {
        ActionResultDTO<MyEntity3063MultiMultivalueDTO> contactDTOActionResultDTO;
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
    public Actions<MyEntity3063MultiMultivalueDTO> getActions() {
        return Actions.<MyEntity3063MultiMultivalueDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]
}