package org.demo.documentation.other.savewithparent.example3.client;

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
public class MyExample3425Service extends VersionAwareResponseService<MyExample3425DTO, MyEntity3425> {

    private final MyEntity3425Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3425Meta> meta = MyExample3425Meta.class;

    @Override
    protected CreateResult<MyExample3425DTO> doCreateEntity(MyEntity3425 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3425DTO> doUpdateEntity(MyEntity3425 entity, MyExample3425DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3425DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3425DTO> getActions() {
        return Actions.<MyExample3425DTO>builder()
               .save(sv -> sv.text("Save"))
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
