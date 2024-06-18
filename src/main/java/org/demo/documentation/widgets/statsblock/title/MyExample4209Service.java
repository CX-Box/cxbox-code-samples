package org.demo.documentation.widgets.statsblock.title;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4209Service extends VersionAwareResponseService<MyExample4209DTO, MyEntity4209> {

    private final MyEntity4209Repository repository;

    public MyExample4209Service(MyEntity4209Repository repository) {
        super(MyExample4209DTO.class, MyEntity4209.class, null, MyExample4209Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4209DTO> doCreateEntity(MyEntity4209 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4209DTO> doUpdateEntity(MyEntity4209 entity, MyExample4209DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4209DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4209DTO> getActions() {
        return Actions.<MyExample4209DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}