package org.demo.documentation.time.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3507Service extends VersionAwareResponseService<MyExample3507DTO, MyEntity3507> {

    private final MyEntity3507Repository repository;

    public MyExample3507Service(MyEntity3507Repository repository) {
        super(MyExample3507DTO.class, MyEntity3507.class, null, MyExample3507Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3507DTO> doCreateEntity(MyEntity3507 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3507DTO> doUpdateEntity(MyEntity3507 entity, MyExample3507DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample3507DTO_.customField)) {
        entity.setCustomField(data.getCustomField());
      }

      return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3507DTO> getActions() {
        return Actions.<MyExample3507DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}