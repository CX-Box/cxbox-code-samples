package org.demo.documentation.widgets.picklist.actions.createwithparent;

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
public class MyEntity3074PickPickService extends VersionAwareResponseService<MyEntity3074PickPickDTO, MyEntity3074Pick> {

    private final MyEntity3074PickRepository repository;

    public MyEntity3074PickPickService(MyEntity3074PickRepository repository) {
        super(MyEntity3074PickPickDTO.class, MyEntity3074Pick.class, null, MyEntity3074PickPickMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3074PickPickDTO> doCreateEntity(MyEntity3074Pick entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3074PickPickDTO> doUpdateEntity(MyEntity3074Pick entity, MyEntity3074PickPickDTO data, BusinessComponent bc) {
        setIfChanged(data, MyEntity3074PickPickDTO_.customField, entity::setCustomField);
        repository.save(entity);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    @Override
    public ActionResultDTO<MyEntity3074PickPickDTO> deleteEntity(BusinessComponent bc) {
        ActionResultDTO<MyEntity3074PickPickDTO> contactDTOActionResultDTO;
        try {
            contactDTOActionResultDTO = super.deleteEntity(bc);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(e).addPopup("You are trying to delete row, that is referenced from other place in system. Deletion is not available");
        }
        return contactDTOActionResultDTO;
    }
    @Override
    public Actions<MyEntity3074PickPickDTO> getActions() {
        return Actions.<MyEntity3074PickPickDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}