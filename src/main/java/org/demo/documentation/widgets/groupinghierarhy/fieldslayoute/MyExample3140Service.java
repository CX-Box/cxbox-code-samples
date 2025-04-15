package org.demo.documentation.widgets.groupinghierarhy.fieldslayoute;

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
public class MyExample3140Service extends VersionAwareResponseService<MyExample3140DTO, MyEntity3140> {

    private final MyEntity3140Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3140Meta> meta = MyExample3140Meta.class;

    @Override
    protected CreateResult<MyExample3140DTO> doCreateEntity(MyEntity3140 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3140DTO> doUpdateEntity(MyEntity3140 entity, MyExample3140DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3140DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3140DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3140DTO> getActions() {
        return Actions.<MyExample3140DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
