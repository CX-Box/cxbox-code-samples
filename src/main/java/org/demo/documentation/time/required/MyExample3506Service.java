package org.demo.documentation.time.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3506Service extends VersionAwareResponseService<MyExample3506DTO, MyEntity3506> {

    private final MyEntity3506Repository repository;

    public MyExample3506Service(MyEntity3506Repository repository) {
        super(MyExample3506DTO.class, MyEntity3506.class, null, MyExample3506Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3506DTO> doCreateEntity(MyEntity3506 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3506DTO> doUpdateEntity(MyEntity3506 entity, MyExample3506DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample3506DTO_.customField)) {
        entity.setCustomField(data.getCustomField());
      }

      return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3506DTO> getActions() {
        return Actions.<MyExample3506DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}