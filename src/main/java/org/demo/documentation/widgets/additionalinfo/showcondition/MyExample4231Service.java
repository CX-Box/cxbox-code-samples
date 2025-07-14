package org.demo.documentation.widgets.additionalinfo.showcondition;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample4231Service extends VersionAwareResponseService<MyExample4231DTO, MyEntity4231> {

    private final MyEntity4231Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4231Meta> meta = MyExample4231Meta.class;

    @Override
    protected CreateResult<MyExample4231DTO> doCreateEntity(MyEntity4231 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4231DTO> doUpdateEntity(MyEntity4231 entity, MyExample4231DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample4231DTO_.customFieldNum)) {
        entity.setCustomFieldNum(data.getCustomFieldNum());
      }
      if (data.isFieldChanged(MyExample4231DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4231DTO> getActions() {
        return Actions.<MyExample4231DTO>builder()
               .save(sv -> sv.text("Save"))
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}