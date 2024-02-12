package org.demo.documentation.widgets.additionalinfo.base;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3600Service extends VersionAwareResponseService<MyExample3600DTO, MyEntity3600> {

    private final MyEntity3600Repository repository;

    public MyExample3600Service(MyEntity3600Repository repository) {
        super(MyExample3600DTO.class, MyEntity3600.class, null, MyExample3600Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3600DTO> doCreateEntity(MyEntity3600 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3600DTO> doUpdateEntity(MyEntity3600 entity, MyExample3600DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample3600DTO_.customField3)) {
        entity.setCustomField3(data.getCustomField3());
      }
      if (data.isFieldChanged(MyExample3600DTO_.customField2)) {
        entity.setCustomField2(data.getCustomField2());
      }
      if (data.isFieldChanged(MyExample3600DTO_.customField)) {
        entity.setCustomField(data.getCustomField());
      }

      return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3600DTO> getActions() {
        return Actions.<MyExample3600DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}