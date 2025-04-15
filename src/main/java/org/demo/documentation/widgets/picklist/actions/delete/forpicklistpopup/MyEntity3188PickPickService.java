package org.demo.documentation.widgets.picklist.actions.delete.forpicklistpopup;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3188PickPickService extends VersionAwareResponseService<MyEntity3188PickPickDTO, MyEntity3188Pick> {
    private final MyEntity3188PickRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3188PickPickMeta> meta = MyEntity3188PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity3188PickPickDTO> doCreateEntity(MyEntity3188Pick entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyEntity3188PickPickDTO> doUpdateEntity(MyEntity3188Pick entity, MyEntity3188PickPickDTO data,
                                                                      BusinessComponent bc) {
        setIfChanged(data, MyEntity3188PickPickDTO_.customField, entity::setCustomField);
        repository.save(entity);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:deleteEntity]
    @Override
    public ActionResultDTO<MyEntity3188PickPickDTO> deleteEntity(BusinessComponent bc) {
        ActionResultDTO<MyEntity3188PickPickDTO> contactDTOActionResultDTO;
        try {
            contactDTOActionResultDTO = super.deleteEntity(bc);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(e).addPopup("You are trying to delete row, that is referenced from other place in system. Deletion is not available");
        }
        return contactDTOActionResultDTO;
    }
    // --8<-- [end:deleteEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3188PickPickDTO> getActions() {
        return Actions.<MyEntity3188PickPickDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]


}