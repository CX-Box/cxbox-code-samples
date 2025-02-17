package org.demo.documentation.fields.suggestion.validationconfirm.forfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3116Service extends VersionAwareResponseService<MyExample3116DTO, MyEntity3116> {

    private final MyEntity3116Repository repository;

    public MyExample3116Service(MyEntity3116Repository repository) {
        super(MyExample3116DTO.class, MyEntity3116.class, null, MyExample3116Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3116DTO> doCreateEntity(MyEntity3116 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3116DTO> doUpdateEntity(MyEntity3116 entity, MyExample3116DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3116DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3116DTO> getActions() {
        return Actions.<MyExample3116DTO>builder()
                .action(act -> act
                        .action("save", "save")
                        .withPreAction(PreAction.confirm("You want to save the value ?"))
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
