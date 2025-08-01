package org.demo.documentation.widgets.list.title;

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
public class MyExample3104Service extends VersionAwareResponseService<MyExample3104DTO, MyEntity3104> {

    private final MyEntity3104Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3104Meta> meta = MyExample3104Meta.class;

    @Override
    protected CreateResult<MyExample3104DTO> doCreateEntity(MyEntity3104 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3104DTO> doUpdateEntity(MyEntity3104 entity, MyExample3104DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3104DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3104DTO> getActions() {
        return Actions.<MyExample3104DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}