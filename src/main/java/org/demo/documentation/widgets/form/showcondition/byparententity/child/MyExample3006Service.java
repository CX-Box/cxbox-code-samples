package org.demo.documentation.widgets.form.showcondition.byparententity.child;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;


@Service
public class MyExample3006Service extends VersionAwareResponseService<MyExample3006DTO, MyEntity3006> {

    private final MyEntity3006Repository repository;

    public MyExample3006Service(MyEntity3006Repository repository) {
        super(MyExample3006DTO.class, MyEntity3006.class, null, MyExample3006Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3006DTO> doCreateEntity(MyEntity3006 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3006DTO> doUpdateEntity(MyEntity3006 entity, MyExample3006DTO data,
                                                               BusinessComponent bc) {

        if (data.isFieldChanged(MyExample3006DTO_.customField3)) {
            entity.setCustomField3(data.getCustomField3());
        }
        if (data.isFieldChanged(MyExample3006DTO_.customField2)) {
            entity.setCustomField2(data.getCustomField2());
        }


        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3006DTO> getActions() {
        return Actions.<MyExample3006DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
    // --8<-- [end:getActions]

}