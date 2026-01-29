package org.demo.documentation.fields.time.ro;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3507Service extends VersionAwareResponseService<MyExample3507DTO, MyEntity3507> {

    private final MyEntity3507Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3507Meta> meta = MyExample3507Meta.class;

    @Override
    protected CreateResult<MyExample3507DTO> doCreateEntity(MyEntity3507 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }
    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3507DTO> doUpdateEntity(MyEntity3507 entity, MyExample3507DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample3507DTO_.customField)) {
        entity.setCustomField(data.getCustomField());
      }

      return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]
     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3507DTO> getActions() {
        return Actions.<MyExample3507DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}