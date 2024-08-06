package org.demo.documentation.other.twobcshowcondition.child;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3145Service extends VersionAwareResponseService<MyExample3145DTO, MyEntity3145> {

    private final MyEntity3145Repository repository;

    public MyExample3145Service(MyEntity3145Repository repository) {
        super(MyExample3145DTO.class, MyEntity3145.class, null, MyExample3145Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3145DTO> doCreateEntity(MyEntity3145 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3145DTO> doUpdateEntity(MyEntity3145 entity, MyExample3145DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3145DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3145DTO> getActions() {
        return Actions.<MyExample3145DTO>builder()
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

