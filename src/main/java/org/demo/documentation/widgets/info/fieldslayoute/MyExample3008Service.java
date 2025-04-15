package org.demo.documentation.widgets.info.fieldslayoute;

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
public class MyExample3008Service extends VersionAwareResponseService<MyExample3008DTO, MyEntity3008> {

    private final MyEntity3008Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3008Meta> meta = MyExample3008Meta.class;

    @Override
    protected CreateResult<MyExample3008DTO> doCreateEntity(MyEntity3008 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3008DTO> doUpdateEntity(MyEntity3008 entity, MyExample3008DTO data,
                                                               BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3008DTO_.customField4)) {
            entity.setCustomField4(data.getCustomField4());
        }
        if (data.isFieldChanged(MyExample3008DTO_.customField5)) {
            entity.setCustomField5(data.getCustomField5());
        }
        if (data.isFieldChanged(MyExample3008DTO_.customField3)) {
            entity.setCustomField3(data.getCustomField3());
        }
        if (data.isFieldChanged(MyExample3008DTO_.customField2)) {
            entity.setCustomField2(data.getCustomField2());
        }
        if (data.isFieldChanged(MyExample3008DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3008DTO> getActions() {
        return Actions.<MyExample3008DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
    // --8<-- [end:getActions]

}