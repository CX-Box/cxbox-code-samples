package org.demo.documentation.fields.suggestion.placeholder.forfield;

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
public class MyExample3097Service extends VersionAwareResponseService<MyExample3097DTO, MyEntity3097> {

    private final MyEntity3097Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3097Meta> meta = MyExample3097Meta.class;

    @Override
    protected CreateResult<MyExample3097DTO> doCreateEntity(MyEntity3097 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3097DTO> doUpdateEntity(MyEntity3097 entity, MyExample3097DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3097DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3097DTO> getActions() {
        return Actions.<MyExample3097DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
