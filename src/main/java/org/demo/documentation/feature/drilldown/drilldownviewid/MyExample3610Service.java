package org.demo.documentation.feature.drilldown.drilldownviewid;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3610Service extends VersionAwareResponseService<MyExample3610DTO, MyEntity3610> {

    private final MyEntity3610Repository repository;

    public MyExample3610Service(MyEntity3610Repository repository) {
        super(MyExample3610DTO.class, MyEntity3610.class, null, MyExample3610Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3610DTO> doCreateEntity(MyEntity3610 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3610DTO> doUpdateEntity(MyEntity3610 entity, MyExample3610DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3610DTO_.customFieldDrillDown)) {
            entity.setCustomFieldDrillDown(data.getCustomFieldDrillDown());
        }
        if (data.isFieldChanged(MyExample3610DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3610DTO> getActions() {
        return Actions.<MyExample3610DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .create()
                .add()
                .delete()
                .add()
                .build();
    }

     // --8<-- [end:getActions]  
}