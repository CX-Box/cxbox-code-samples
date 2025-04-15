package org.demo.documentation.navigation.tab.typestandard.businessexample.task;

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
public class MyExample3428Service extends VersionAwareResponseService<MyExample3428DTO, MyEntity3428> {

    private final MyEntity3428Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3428Meta> meta = MyExample3428Meta.class;

    @Override
    protected CreateResult<MyExample3428DTO> doCreateEntity(MyEntity3428 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3428DTO> doUpdateEntity(MyEntity3428 entity, MyExample3428DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3428DTO_.meetDate, entity::setMeetDate);
        setIfChanged(data, MyExample3428DTO_.customFieldAdditional, entity::setCustomFieldAdditional);
        setIfChanged(data, MyExample3428DTO_.customFieldDrilldown, entity::setCustomFieldDrilldown);
        if (data.isFieldChanged(MyExample3428DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3428DTO> getActions() {
        return Actions.<MyExample3428DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
