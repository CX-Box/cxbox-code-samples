package org.demo.documentation.fields.time.color;

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
public class MyExample3501Service extends VersionAwareResponseService<MyExample3501DTO, MyEntity3501> {

    private final MyEntity3501Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3501Meta> meta = MyExample3501Meta.class;

    @Override
    protected CreateResult<MyExample3501DTO> doCreateEntity(MyEntity3501 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3501DTO> doUpdateEntity(MyEntity3501 entity, MyExample3501DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample3501DTO_.customField)) {
        entity.setCustomField(data.getCustomField());
      }

      return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3501DTO> getActions() {
        return Actions.<MyExample3501DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}