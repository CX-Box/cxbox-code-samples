package org.demo.documentation.widgets.groupinghierarhy.title;

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
public class MyExample3139Service extends VersionAwareResponseService<MyExample3139DTO, MyEntity3139> {

    private final MyEntity3139Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3139Meta> meta = MyExample3139Meta.class;

    @Override
    protected CreateResult<MyExample3139DTO> doCreateEntity(MyEntity3139 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3139DTO> doUpdateEntity(MyEntity3139 entity, MyExample3139DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3139DTO_.customFieldDictionary, entity::setCustomFieldDictionary);

        if (data.isFieldChanged(MyExample3139DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3139DTO> getActions() {
        return Actions.<MyExample3139DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
