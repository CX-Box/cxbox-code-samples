package org.demo.documentation.fields.suggestion.validationconfirm.forfield;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3116Service extends VersionAwareResponseService<MyExample3116DTO, MyEntity3116> {

    private final MyEntity3116Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3116Meta> meta = MyExample3116Meta.class;

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
