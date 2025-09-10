package org.demo.documentation.widgets.statsblock.drilldown.drilldown.data;

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
public class MyExample4208Service extends VersionAwareResponseService<MyExample4208DTO, MyEntity4208> {

    private final MyEntity4208Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4208Meta> meta = MyExample4208Meta.class;

    @Override
    protected CreateResult<MyExample4208DTO> doCreateEntity(MyEntity4208 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4208DTO> doUpdateEntity(MyEntity4208 entity, MyExample4208DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4208DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4208DTO> getActions() {
        return Actions.<MyExample4208DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}