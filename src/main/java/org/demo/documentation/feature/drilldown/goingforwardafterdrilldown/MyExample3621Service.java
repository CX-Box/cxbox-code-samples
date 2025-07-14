package org.demo.documentation.feature.drilldown.goingforwardafterdrilldown;

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

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3621Service extends VersionAwareResponseService<MyExample3621DTO, MyEntity3621> {

    private final MyEntity3621Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3621Meta> meta = MyExample3621Meta.class;

    @Override
    protected CreateResult<MyExample3621DTO> doCreateEntity(MyEntity3621 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3621DTO> doUpdateEntity(MyEntity3621 entity, MyExample3621DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3621DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3621DTO> getActions() {
        return Actions.<MyExample3621DTO>builder()
               .save(sv -> sv.text("Save"))
                .action(act -> act
                        .scope(ActionScope.RECORD)
                        .action("gotolist", "Go to List")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3621DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3621/"
                                    ));
                        })
                )
                .action(act -> act
                        .scope(ActionScope.RECORD)
                        .action("gotostep2", "Go to Step2")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3621DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3621/view/myexample3621form/"
                                    ));
                        })
                )
                .action(act -> act
                        .scope(ActionScope.RECORD)
                        .action("gotostep3", "Go to Step3")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3621DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3621/view/myexample3621info2"
                                    ));
                        })
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
