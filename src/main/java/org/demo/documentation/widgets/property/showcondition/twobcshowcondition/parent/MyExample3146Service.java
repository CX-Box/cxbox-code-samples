package org.demo.documentation.widgets.property.showcondition.twobcshowcondition.parent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3146Service extends VersionAwareResponseService<MyExample3146DTO, MyEntity3146> {

    private final MyEntity3146Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3146Meta> meta = MyExample3146Meta.class;

    @Override
    protected CreateResult<MyExample3146DTO> doCreateEntity(MyEntity3146 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3146DTO> doUpdateEntity(MyEntity3146 entity, MyExample3146DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3146DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3146DTO> getActions() {
        return Actions.<MyExample3146DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]
}

