package org.demo.documentation.widgets.assoc.actions.other.createwithparent.assoc;

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
public class MyEntity3662MultivalueService extends VersionAwareResponseService<MyEntity3662MultivalueDTO, MyEntity3662> {
    private final MyEntity3662MultiRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3662MultivalueMeta> meta = MyEntity3662MultivalueMeta.class;

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

     // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3662MultivalueDTO> getActions() {
        return Actions.<MyEntity3662MultivalueDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
}