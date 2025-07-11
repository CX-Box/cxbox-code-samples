package org.demo.documentation.feature.drilldown.goingbackafterdrilldown;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3620Service extends VersionAwareResponseService<MyExample3620DTO, MyEntity3620> {

    private final MyEntity3620Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3620Meta> meta = MyExample3620Meta.class;

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
               .save(sv -> sv.text("Save"))
                .action(act -> act
                        .scope(ActionScope.RECORD)
                        .action("gotolist", "Go to List")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3620DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3620"
                                    ));
                        })
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
