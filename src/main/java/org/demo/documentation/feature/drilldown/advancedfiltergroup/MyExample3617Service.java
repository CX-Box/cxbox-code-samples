package org.demo.documentation.feature.drilldown.advancedfiltergroup;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3617Service extends VersionAwareResponseService<MyExample3617DTO, MyEntity3617> {

    private final MyEntity3617Repository repository;

    public MyExample3617Service(MyEntity3617Repository repository) {
        super(MyExample3617DTO.class, MyEntity3617.class, null, MyExample3617Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3617DTO> doCreateEntity(MyEntity3617 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3617DTO> doUpdateEntity(MyEntity3617 entity, MyExample3617DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3617DTO_.customFieldDrillDown)) {
            entity.setCustomFieldDrillDown(data.getCustomFieldDrillDown());
        }
        if (data.isFieldChanged(MyExample3617DTO_.customFieldNew)) {
            entity.setCustomFieldNew(data.getCustomFieldNew());
        }
        if (data.isFieldChanged(MyExample3617DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3617DTO> getActions() {
        return Actions.<MyExample3617DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .create()
                .add()
                .delete()
                .add()
                .build();
    }


}

