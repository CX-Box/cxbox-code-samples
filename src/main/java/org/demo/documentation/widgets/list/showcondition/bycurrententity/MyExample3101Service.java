package org.demo.documentation.widgets.list.showcondition.bycurrententity;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3101Service extends VersionAwareResponseService<MyExample3101DTO, MyEntity3101> {

    private final MyEntity3101Repository repository;

    public MyExample3101Service(MyEntity3101Repository repository) {
        super(MyExample3101DTO.class, MyEntity3101.class, null, MyExample3101Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3101DTO> doCreateEntity(MyEntity3101 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3101DTO> doUpdateEntity(MyEntity3101 entity, MyExample3101DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3101DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3101DTO> getActions() {
        return Actions.<MyExample3101DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}