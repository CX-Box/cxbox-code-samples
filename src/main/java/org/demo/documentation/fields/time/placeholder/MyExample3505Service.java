package org.demo.documentation.fields.time.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3505Service extends VersionAwareResponseService<MyExample3505DTO, MyEntity3505> {

    private final MyEntity3505Repository repository;

    public MyExample3505Service(MyEntity3505Repository repository) {
        super(MyExample3505DTO.class, MyEntity3505.class, null, MyExample3505Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3505DTO> doCreateEntity(MyEntity3505 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3505DTO> doUpdateEntity(MyEntity3505 entity, MyExample3505DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample3505DTO_.customField)) {
        entity.setCustomField(data.getCustomField());
      }

      return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3505DTO> getActions() {
        return Actions.<MyExample3505DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}