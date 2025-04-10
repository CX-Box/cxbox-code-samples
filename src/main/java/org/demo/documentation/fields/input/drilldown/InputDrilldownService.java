package org.demo.documentation.fields.input.drilldown;

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
public class InputDrilldownService extends VersionAwareResponseService<InputDrilldownDTO, InputDrilldown> {

    private final InputDrilldownRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<InputDrilldownMeta> meta = InputDrilldownMeta.class;

    @Override
    protected CreateResult<InputDrilldownDTO> doCreateEntity(InputDrilldown entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<InputDrilldownDTO> doUpdateEntity(InputDrilldown entity, InputDrilldownDTO data,
                                                                BusinessComponent bc) {
        if (data.isFieldChanged(InputDrilldownDTO_.customField2)) {
            entity.setCustomField2(data.getCustomField2());
        }
        if (data.isFieldChanged(InputDrilldownDTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<InputDrilldownDTO> getActions() {
        return Actions.<InputDrilldownDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
    // --8<-- [end:getActions]


}
