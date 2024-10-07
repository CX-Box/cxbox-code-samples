package org.demo.documentation.feature.drilldown.simple;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3611Service extends VersionAwareResponseService<MyExample3611DTO, MyEntity3611> {

    private final MyEntity3611Repository repository;

    public MyExample3611Service(MyEntity3611Repository repository) {
        super(MyExample3611DTO.class, MyEntity3611.class, null, MyExample3611Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3611DTO> doCreateEntity(MyEntity3611 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3611DTO> doUpdateEntity(MyEntity3611 entity, MyExample3611DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3611DTO_.customFieldDrillDowm)) {
            entity.setCustomFieldDrillDowm(data.getCustomFieldDrillDowm());
        }
        if (data.isFieldChanged(MyExample3611DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3611DTO> getActions() {
        return Actions.<MyExample3611DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}