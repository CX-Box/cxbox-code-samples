package org.demo.documentation.widgets.assoc.color;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3053Service extends VersionAwareResponseService<MyExample3053DTO, MyEntity3053> {

    private final MyEntity3053Repository repository;

    public MyExample3053Service(MyEntity3053Repository repository) {
        super(MyExample3053DTO.class, MyEntity3053.class, null, MyExample3053Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3053DTO> doCreateEntity(MyEntity3053 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3053DTO> doUpdateEntity(MyEntity3053 entity, MyExample3053DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3053DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3053DTO> getActions() {
        return Actions.<MyExample3053DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .create()
                .add()
                .delete()
                .add()
                .build();
    }


}

