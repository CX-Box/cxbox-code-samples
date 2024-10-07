package org.demo.documentation.widgets.form.showcondition.bycurrententity;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3005Service extends VersionAwareResponseService<MyExample3005DTO, MyEntity3005> {

    private final MyEntity3005Repository repository;

    public MyExample3005Service(MyEntity3005Repository repository) {
        super(MyExample3005DTO.class, MyEntity3005.class, null, MyExample3005Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3005DTO> doCreateEntity(MyEntity3005 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3005DTO> doUpdateEntity(MyEntity3005 entity, MyExample3005DTO data,
                                                               BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3005DTO_.customField2)) {
            entity.setCustomField2(data.getCustomField2());
        }
        if (data.isFieldChanged(MyExample3005DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3005DTO> getActions() {
        return Actions.<MyExample3005DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
    // --8<-- [end:getActions]

}