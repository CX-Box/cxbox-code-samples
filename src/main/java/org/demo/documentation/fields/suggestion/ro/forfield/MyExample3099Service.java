package org.demo.documentation.fields.suggestion.ro.forfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3099Service extends VersionAwareResponseService<MyExample3099DTO, MyEntity3099> {

    private final MyEntity3099Repository repository;

    public MyExample3099Service(MyEntity3099Repository repository) {
        super(MyExample3099DTO.class, MyEntity3099.class, null, MyExample3099Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3099DTO> doCreateEntity(MyEntity3099 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3099DTO> doUpdateEntity(MyEntity3099 entity, MyExample3099DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3099DTO> getActions() {
        return Actions.<MyExample3099DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }


}

