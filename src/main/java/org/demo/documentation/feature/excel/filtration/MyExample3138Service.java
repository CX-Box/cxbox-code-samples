package org.demo.documentation.feature.excel.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3138Service extends VersionAwareResponseService<MyExample3138DTO, MyEntity3138> {

    private final MyEntity3138Repository repository;

    public MyExample3138Service(MyEntity3138Repository repository) {
        super(MyExample3138DTO.class, MyEntity3138.class, null, MyExample3138Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3138DTO> doCreateEntity(MyEntity3138 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3138DTO> doUpdateEntity(MyEntity3138 entity, MyExample3138DTO data, BusinessComponent bc) {
      setIfChanged(data, MyExample3138DTO_.customFieldText, entity::setCustomFieldText);
      setIfChanged(data, MyExample3138DTO_.customFieldInput, entity::setCustomFieldInput);
      setIfChanged(data, MyExample3138DTO_.customFieldNumber, entity::setCustomFieldNumber);
      setIfChanged(data, MyExample3138DTO_.customFieldDateTime, entity::setCustomFieldDateTime);

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3138DTO> getActions() {
        return Actions.<MyExample3138DTO>builder()
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

