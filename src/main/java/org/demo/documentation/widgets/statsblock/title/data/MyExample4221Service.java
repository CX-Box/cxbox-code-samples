package org.demo.documentation.widgets.statsblock.title.data;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample4221Service extends VersionAwareResponseService<MyExample4221DTO, MyEntity4221> {

    private final MyEntity4221Repository repository;

    public MyExample4221Service(MyEntity4221Repository repository) {
        super(MyExample4221DTO.class, MyEntity4221.class, null, MyExample4221Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4221DTO> doCreateEntity(MyEntity4221 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4221DTO> doUpdateEntity(MyEntity4221 entity, MyExample4221DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4221DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4221DTO> getActions() {
        return Actions.<MyExample4221DTO>builder()
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
