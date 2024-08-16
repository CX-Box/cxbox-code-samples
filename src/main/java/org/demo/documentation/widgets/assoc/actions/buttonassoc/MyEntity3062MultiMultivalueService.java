package org.demo.documentation.widgets.assoc.actions.buttonassoc;

import lombok.Getter;
import org.cxbox.core.exception.BusinessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3062MultiMultivalueService extends VersionAwareResponseService<MyEntity3062MultiMultivalueDTO, MyEntity3062Multi> {
    private final MyEntity3062MultiRepository repository;

    public MyEntity3062MultiMultivalueService(MyEntity3062MultiRepository repository) {
        super(MyEntity3062MultiMultivalueDTO.class, MyEntity3062Multi.class, null, MyEntity3062MultiMultivalueMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3062MultiMultivalueDTO> doCreateEntity(MyEntity3062Multi entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3062MultiMultivalueDTO> doUpdateEntity(MyEntity3062Multi entity, MyEntity3062MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        repository.save(entity);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public ActionResultDTO<MyEntity3062MultiMultivalueDTO> deleteEntity(BusinessComponent bc) {
        ActionResultDTO<MyEntity3062MultiMultivalueDTO> contactDTOActionResultDTO;
        try {
            contactDTOActionResultDTO = super.deleteEntity(bc);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(e).addPopup("You are trying to delete row, that is referenced from other place in system. Deletion is not available");
        }
        return contactDTOActionResultDTO;
    }


}