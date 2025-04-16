package org.demo.documentation.fields.suggestion.filtration.forfield;

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
public class MyExample3096Service extends VersionAwareResponseService<MyExample3096DTO, MyEntity3096> {

    private final MyEntity3096Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3096Meta> meta = MyExample3096Meta.class;

    @Override
    protected CreateResult<MyExample3096DTO> doCreateEntity(MyEntity3096 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3096DTO> doUpdateEntity(MyEntity3096 entity, MyExample3096DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3096DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3096DTO> getActions() {
        return Actions.<MyExample3096DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
