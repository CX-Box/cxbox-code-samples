package org.demo.documentation.time.validationannotation;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4100Service extends VersionAwareResponseService<MyExample4100DTO, MyEntity4100> {

    private final MyEntity4100Repository repository;

    public MyExample4100Service(MyEntity4100Repository repository) {
        super(MyExample4100DTO.class, MyEntity4100.class, null, MyExample4100Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4100DTO> doCreateEntity(MyEntity4100 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4100DTO> doUpdateEntity(MyEntity4100 entity, MyExample4100DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4100DTO> getActions() {
        return Actions.<MyExample4100DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}