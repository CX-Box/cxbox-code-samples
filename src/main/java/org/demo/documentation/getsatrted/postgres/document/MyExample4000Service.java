package org.demo.documentation.getsatrted.postgres.document;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4000Service extends VersionAwareResponseService<MyExample4000DTO, MyEntity4000> {

    private final MyEntity4000Repository repository;

    public MyExample4000Service(MyEntity4000Repository repository) {
        super(MyExample4000DTO.class, MyEntity4000.class, null, MyExample4000Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4000DTO> doCreateEntity(MyEntity4000 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4000DTO> doUpdateEntity(MyEntity4000 entity, MyExample4000DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4000DTO> getActions() {
        return Actions.<MyExample4000DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}