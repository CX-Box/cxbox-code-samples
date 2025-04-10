package org.demo.documentation.widgets.form.title;

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
public class MyExample3003Service extends VersionAwareResponseService<MyExample3003DTO, MyEntity3003> {

    private final MyEntity3003Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3003Meta> meta = MyExample3003Meta.class;

    @Override
    protected CreateResult<MyExample3003DTO> doCreateEntity(MyEntity3003 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3003DTO> doUpdateEntity(MyEntity3003 entity, MyExample3003DTO data,
                                                               BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3003DTO_.customField2)) {
            entity.setCustomField2(data.getCustomField2());
        }

        if (data.isFieldChanged(MyExample3003DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3003DTO> getActions() {
        return Actions.<MyExample3003DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
    // --8<-- [end:getActions]

}