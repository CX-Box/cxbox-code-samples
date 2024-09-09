package org.demo.documentation.navigation.tab.other.example4;

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
public class MyExample3156Service extends VersionAwareResponseService<MyExample3156DTO, MyEntity3156> {

    private final MyEntity3156Repository repository;

    public MyExample3156Service(MyEntity3156Repository repository) {
        super(MyExample3156DTO.class, MyEntity3156.class, null, MyExample3156Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3156DTO> doCreateEntity(MyEntity3156 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3156DTO> doUpdateEntity(MyEntity3156 entity, MyExample3156DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3156DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3156DTO> getActions() {
        return Actions.<MyExample3156DTO>builder()
                .newAction()
                .action("gotolistthirdlevel", "Go to List 3 level")
                .invoker((bc, dto) -> {
                    return new ActionResultDTO<MyExample3156DTO>().setAction(
                            PostAction.drillDown(
                                    DrillDownType.INNER,
                                    "/screen/myexample3156/view/myexample3156infothirdlevel3"
                            ));
                })
                .add()
                .newAction()
                .scope(ActionScope.RECORD)
                .action("gotolistfourthlevel", "Go to List 4 level")
                .invoker((bc, dto) -> {
                    return new ActionResultDTO<MyExample3156DTO>().setAction(
                            PostAction.drillDown(
                                    DrillDownType.INNER,
                                    "/screen/myexample3156/view/myexample3156infofourthlevel3"
                            ));
                })
                .add()
                .newAction()
                .scope(ActionScope.RECORD)
                .action("gotolistsecondlevel", "Go to List 2 level")
                .invoker((bc, dto) -> {
                    return new ActionResultDTO<MyExample3156DTO>().setAction(
                            PostAction.drillDown(
                                    DrillDownType.INNER,
                                    "/screen/myexample3156/view/myexample3156secondlevel"
                            ));
                })
                .add()
                .build();
    }


}

