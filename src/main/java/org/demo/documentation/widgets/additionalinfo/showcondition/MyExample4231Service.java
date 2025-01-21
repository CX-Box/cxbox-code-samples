package org.demo.documentation.widgets.additionalinfo.showcondition;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4231Service extends VersionAwareResponseService<MyExample4231DTO, MyEntity4231> {

    private final MyEntity4231Repository repository;

    public MyExample4231Service(MyEntity4231Repository repository) {
        super(MyExample4231DTO.class, MyEntity4231.class, null, MyExample4231Meta.class);
        this.repository = repository;
    }

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
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}