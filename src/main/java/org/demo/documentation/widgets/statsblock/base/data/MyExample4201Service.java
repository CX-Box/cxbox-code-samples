package org.demo.documentation.widgets.statsblock.base.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4201Service extends VersionAwareResponseService<MyExample4201DTO, MyEntity4201> {

    private final MyEntity4201Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4201Meta> meta = MyExample4201Meta.class;

    @Override
    protected CreateResult<MyExample4201DTO> doCreateEntity(MyEntity4201 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4201DTO> doUpdateEntity(MyEntity4201 entity, MyExample4201DTO data, BusinessComponent bc) {

        if (data.isFieldChanged(MyExample4201DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        if (data.isFieldChanged(MyExample4201DTO_.customFieldNum)) {
            entity.setCustomFieldNum(data.getCustomFieldNum());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4201DTO> getActions() {
        return Actions.<MyExample4201DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}