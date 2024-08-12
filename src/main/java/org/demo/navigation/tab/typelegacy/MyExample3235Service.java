package org.demo.navigation.tab.typelegacy;

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
public class MyExample3235Service extends VersionAwareResponseService<MyExample3235DTO, MyEntity3235> {

    private final MyEntity3235Repository repository;

    public MyExample3235Service(MyEntity3235Repository repository) {
        super(MyExample3235DTO.class, MyEntity3235.class, null, MyExample3235Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3235DTO> doCreateEntity(MyEntity3235 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3235DTO> doUpdateEntity(MyEntity3235 entity, MyExample3235DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3235DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3235DTO> getActions() {
        return Actions.<MyExample3235DTO>builder()
                .newAction()
                .add()
                .create()
                .add()
                .delete()
                .add()
                .action("save", "save")
                .add()
                .newAction()
                .scope(ActionScope.RECORD)
                .action("gotolistthirdlevel", "Go to List 3 level")
                .invoker((bc, dto) -> {
                    return new ActionResultDTO<MyExample3235DTO>().setAction(
                            PostAction.drillDown(
                                    DrillDownType.INNER,
                                    "/screen/myexample3235/view/myexample3235thirdleveltab3"
                            ));
                })
                .add()
                .newAction()
                .scope(ActionScope.RECORD)
                .action("gotolistfourthlevel", "Go to List 4 level")
                .invoker((bc, dto) -> {
                    return new ActionResultDTO<MyExample3235DTO>().setAction(
                            PostAction.drillDown(
                                    DrillDownType.INNER,
                                    "/screen/myexample32353/view/myexample3235fourthleveltab3"
                            ));
                })
                .add()
                .build();
    }


}

