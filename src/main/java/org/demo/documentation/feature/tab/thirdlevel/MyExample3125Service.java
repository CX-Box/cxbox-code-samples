package org.demo.documentation.feature.tab.thirdlevel;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3125Service extends VersionAwareResponseService<MyExample3125DTO, MyEntity3125> {

    private final MyEntity3125Repository repository;

    public MyExample3125Service(MyEntity3125Repository repository) {
        super(MyExample3125DTO.class, MyEntity3125.class, null, MyExample3125Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3125DTO> doCreateEntity(MyEntity3125 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3125DTO> doUpdateEntity(MyEntity3125 entity, MyExample3125DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3125DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3125DTO> getActions() {
        return Actions.<MyExample3125DTO>builder()
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

