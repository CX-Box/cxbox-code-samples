package org.demo.documentation.widgets.form.showcondition.byparententity.parent;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3007Service extends VersionAwareResponseService<MyExample3007DTO, MyEntity3007> {

    private final MyEntity3007Repository repository;

    public MyExample3007Service(MyEntity3007Repository repository) {
        super(MyExample3007DTO.class, MyEntity3007.class, null, MyExample3007Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3007DTO> doCreateEntity(MyEntity3007 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3007DTO> doUpdateEntity(MyEntity3007 entity, MyExample3007DTO data,
                                                               BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3007DTO_.customFieldShowCondition)) {
            entity.setCustomFieldShowCondition(data.getCustomFieldShowCondition());
        }
        if (data.isFieldChanged(MyExample3007DTO_.customField4)) {
            entity.setCustomField4(data.getCustomField4());
        }

        if (data.isFieldChanged(MyExample3007DTO_.customField3)) {
            entity.setCustomField3(data.getCustomField3());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3007DTO> getActions() {
        return Actions.<MyExample3007DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
    // --8<-- [end:getActions]

}