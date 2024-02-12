package org.demo.documentation.time.base;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3500Service extends VersionAwareResponseService<MyExample3500DTO, MyEntity3500> {

    private final MyEntity3500Repository repository;

    public MyExample3500Service(MyEntity3500Repository repository) {
        super(MyExample3500DTO.class, MyEntity3500.class, null, MyExample3500Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3500DTO> doCreateEntity(MyEntity3500 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3500DTO> doUpdateEntity(MyEntity3500 entity, MyExample3500DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3500DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3500DTO> getActions() {
        return Actions.<MyExample3500DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}