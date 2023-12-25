package org.demo.documentation.widgets.list.showcondition.byparententity.child;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3106Service extends VersionAwareResponseService<MyExample3106DTO, MyEntity3106> {

    private final MyEntity3106Repository repository;

    public MyExample3106Service(MyEntity3106Repository repository) {
        super(MyExample3106DTO.class, MyEntity3106.class, null, MyExample3106Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3106DTO> doCreateEntity(MyEntity3106 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3106DTO> doUpdateEntity(MyEntity3106 entity, MyExample3106DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3106DTO> getActions() {
        return Actions.<MyExample3106DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}