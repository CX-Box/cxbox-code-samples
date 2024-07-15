package org.demo.documentation.fields.time.validationbusinessex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4101Service extends VersionAwareResponseService<MyExample4101DTO, MyEntity4101> {

    private final MyEntity4101Repository repository;

    public MyExample4101Service(MyEntity4101Repository repository) {
        super(MyExample4101DTO.class, MyEntity4101.class, null, MyExample4101Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4101DTO> doCreateEntity(MyEntity4101 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4101DTO> doUpdateEntity(MyEntity4101 entity, MyExample4101DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4101DTO> getActions() {
        return Actions.<MyExample4101DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}