package org.demo.documentation.getsatrted.microservice;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4001Service extends VersionAwareResponseService<MyExample4001DTO, MyEntity4001> {

    private final MyEntity4001Repository repository;

    public MyExample4001Service(MyEntity4001Repository repository) {
        super(MyExample4001DTO.class, MyEntity4001.class, null, MyExample4001Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4001DTO> doCreateEntity(MyEntity4001 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4001DTO> doUpdateEntity(MyEntity4001 entity, MyExample4001DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4001DTO> getActions() {
        return Actions.<MyExample4001DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}