package org.demo.documentation.widgets.statsblock.icon.data;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample4222Service extends VersionAwareResponseService<MyExample4222DTO, MyEntity4222> {

    private final MyEntity4222Repository repository;

    public MyExample4222Service(MyEntity4222Repository repository) {
        super(MyExample4222DTO.class, MyEntity4222.class, null, MyExample4222Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4222DTO> doCreateEntity(MyEntity4222 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4222DTO> doUpdateEntity(MyEntity4222 entity, MyExample4222DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4222DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4222DTO> getActions() {
        return Actions.<MyExample4222DTO>builder()
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
