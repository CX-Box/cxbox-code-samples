package org.demo.documentation.widgets.info.title;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3102Service extends VersionAwareResponseService<MyExample3102DTO, MyEntity3102> {

    private final MyEntity3102Repository repository;

    public MyExample3102Service(MyEntity3102Repository repository) {
        super(MyExample3102DTO.class, MyEntity3102.class, null, MyExample3102Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3102DTO> doCreateEntity(MyEntity3102 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3102DTO> doUpdateEntity(MyEntity3102 entity, MyExample3102DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample3102DTO_.customField)) {
        entity.setCustomField(data.getCustomField());
      }

      return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3102DTO> getActions() {
        return Actions.<MyExample3102DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}