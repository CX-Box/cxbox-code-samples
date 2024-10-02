package org.demo.documentation.widgets.info.showcondition.byparententity.parent;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3105Service extends VersionAwareResponseService<MyExample3105DTO, MyEntity3105> {

    private final MyEntity3105Repository repository;

    public MyExample3105Service(MyEntity3105Repository repository) {
        super(MyExample3105DTO.class, MyEntity3105.class, null, MyExample3105Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3105DTO> doCreateEntity(MyEntity3105 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3105DTO> doUpdateEntity(MyEntity3105 entity, MyExample3105DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3105DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
            entity.setCustomFieldShowCondition(data.getCustomFieldShowCondition());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3105DTO> getActions() {
        return Actions.<MyExample3105DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}