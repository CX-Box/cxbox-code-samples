package org.demo.documentation.fields.suggestion.validationannotation.forfield;

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
public class MyExample3111Service extends VersionAwareResponseService<MyExample3111DTO, MyEntity3111> {

    private final MyEntity3111Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3111Meta> meta = MyExample3111Meta.class;

    @Override
    protected CreateResult<MyExample3111DTO> doCreateEntity(MyEntity3111 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3111DTO> doUpdateEntity(MyEntity3111 entity, MyExample3111DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3111DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3111DTO> getActions() {
        return Actions.<MyExample3111DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}
