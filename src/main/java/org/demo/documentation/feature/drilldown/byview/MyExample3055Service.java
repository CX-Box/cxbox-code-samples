package org.demo.documentation.feature.drilldown.byview;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.navigation.tab.typelegacy.MyExample3235DTO;
import org.springframework.stereotype.Service;

@Service
public class MyExample3055Service extends VersionAwareResponseService<MyExample3055DTO, MyEntity3055> {

    private final MyEntity3055Repository repository;

    public MyExample3055Service(MyEntity3055Repository repository) {
        super(MyExample3055DTO.class, MyEntity3055.class, null, MyExample3055Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3055DTO> doCreateEntity(MyEntity3055 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3055DTO> doUpdateEntity(MyEntity3055 entity, MyExample3055DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3055DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3055DTO> getActions() {
        return Actions.<MyExample3055DTO>builder()
                .newAction()
                .scope(ActionScope.RECORD)
                .action("gotoonerecord", "Go to List 3 level")
                .invoker((bc, dto) -> {
                    return new ActionResultDTO<MyExample3055DTO>().setAction(
                            PostAction.drillDown(
                                    DrillDownType.INNER,
                                    "/screen/myexample3055/view/myexample3055info/myexample3055/1100023"
                            ));
                })
                .add()
                .build();
    }


}

