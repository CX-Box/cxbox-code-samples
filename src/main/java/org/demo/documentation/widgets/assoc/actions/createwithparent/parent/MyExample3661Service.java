package org.demo.documentation.widgets.assoc.actions.createwithparent.parent;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3661Service extends VersionAwareResponseService<MyExample3661DTO, MyEntity3661> {

    private final MyEntity3661Repository repository;

    public MyExample3661Service(MyEntity3661Repository repository) {
        super(MyExample3661DTO.class, MyEntity3661.class, null, MyExample3661Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3661DTO> doCreateEntity(MyEntity3661 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3661DTO> doUpdateEntity(MyEntity3661 entity, MyExample3661DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3661DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3661DTO> getActions() {
        return Actions.<MyExample3661DTO>builder()
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

