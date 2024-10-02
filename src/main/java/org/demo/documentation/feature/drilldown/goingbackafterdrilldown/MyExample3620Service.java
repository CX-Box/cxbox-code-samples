package org.demo.documentation.feature.drilldown.goingbackafterdrilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3620Service extends VersionAwareResponseService<MyExample3620DTO, MyEntity3620> {

    private final MyEntity3620Repository repository;

    public MyExample3620Service(MyEntity3620Repository repository) {
        super(MyExample3620DTO.class, MyEntity3620.class, null, MyExample3620Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3620DTO> doCreateEntity(MyEntity3620 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3620DTO> doUpdateEntity(MyEntity3620 entity, MyExample3620DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3620DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3620DTO> getActions() {
        return Actions.<MyExample3620DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .newAction()
                .scope(ActionScope.RECORD)
                .action("gotolist", "Go to List")
                .invoker((bc, dto) -> {
                    return new ActionResultDTO<MyExample3620DTO>().setAction(
                            PostAction.drillDown(
                                    DrillDownType.INNER,
                                    "/screen/myexample3620"
                            ));
                })
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}
