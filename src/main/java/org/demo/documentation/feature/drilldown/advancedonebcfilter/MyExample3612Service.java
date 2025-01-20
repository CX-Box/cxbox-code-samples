package org.demo.documentation.feature.drilldown.advancedonebcfilter;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.drilldown.advancedonebcfilter.MyExample3612DTO_;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3612Service extends VersionAwareResponseService<MyExample3612DTO, MyEntity3612> {

    private final MyEntity3612Repository repository;

    public MyExample3612Service(MyEntity3612Repository repository) {
        super(MyExample3612DTO.class, MyEntity3612.class, null, MyExample3612Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3612DTO> doCreateEntity(MyEntity3612 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3612DTO> doUpdateEntity(MyEntity3612 entity, MyExample3612DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3612DTO_.customFieldFilterDictionary)) {
            entity.setCustomFieldFilterDictionary(data.getCustomFieldFilterDictionary());
        }
        if (data.isFieldChanged(MyExample3612DTO_.customFieldFilterDate)) {
            entity.setCustomFieldFilterDate(data.getCustomFieldFilterDate());
        }
        if (data.isFieldChanged(MyExample3612DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3612DTO> getActions() {
        return Actions.<MyExample3612DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
