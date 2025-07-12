package org.demo.documentation.fields.suggestion.required.forfield;

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
public class MyExample3098Service extends VersionAwareResponseService<MyExample3098DTO, MyEntity3098> {

    private final MyEntity3098Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3098Meta> meta = MyExample3098Meta.class;

    @Override
    protected CreateResult<MyExample3098DTO> doCreateEntity(MyEntity3098 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3098DTO> doUpdateEntity(MyEntity3098 entity, MyExample3098DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3098DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3098DTO> getActions() {
        return Actions.<MyExample3098DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}
