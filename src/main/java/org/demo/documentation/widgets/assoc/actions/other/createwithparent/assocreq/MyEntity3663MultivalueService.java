package org.demo.documentation.widgets.assoc.actions.other.createwithparent.assocreq;

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
public class MyEntity3663MultivalueService extends VersionAwareResponseService<MyEntity3663MultivalueDTO, MyEntity3663> {
    private final MyEntity3663MultiRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3663MultivalueMeta> meta = MyEntity3663MultivalueMeta.class;

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

     // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3663MultivalueDTO> getActions() {
        return Actions.<MyEntity3663MultivalueDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
}