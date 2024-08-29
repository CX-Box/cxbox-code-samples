package org.demo.documentation.other.savewithparent.example1;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3132Service extends VersionAwareResponseService<MyExample3132DTO, MyEntity3132> {

    private final MyEntity3132Repository repository;

    public MyExample3132Service(MyEntity3132Repository repository) {
        super(MyExample3132DTO.class, MyEntity3132.class, null, MyExample3132Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3132DTO> doCreateEntity(MyEntity3132 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3132DTO> doUpdateEntity(MyEntity3132 entity, MyExample3132DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3132DTO_.customField3, entity::setCustomField3);
        setIfChanged(data, MyExample3132DTO_.customField2, entity::setCustomField2);
        if (data.isFieldChanged(MyExample3132DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3132DTO> getActions() {
        return Actions.<MyExample3132DTO>builder()
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

