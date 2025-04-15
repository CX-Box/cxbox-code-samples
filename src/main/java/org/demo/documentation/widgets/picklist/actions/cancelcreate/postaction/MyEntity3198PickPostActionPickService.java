package org.demo.documentation.widgets.picklist.actions.cancelcreate.postaction;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3198PickPostActionPickService extends VersionAwareResponseService<MyEntity3198PickPostActionPickDTO, MyEntity3198PickPostAction> {
    private final MyEntity3198PickPostActionRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3198PickPostActionPickMeta> meta = MyEntity3198PickPostActionPickMeta.class;

    @Override
    protected CreateResult<MyEntity3198PickPostActionPickDTO> doCreateEntity(MyEntity3198PickPostAction entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3198PickPostActionPickDTO> doUpdateEntity(MyEntity3198PickPostAction entity, MyEntity3198PickPostActionPickDTO data,
                                                                                BusinessComponent bc) {
        setIfChanged(data, MyEntity3198PickPostActionPickDTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3198PickPostActionPickDTO> getActions() {
        return Actions.<MyEntity3198PickPostActionPickDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .action(act -> act
                        .action("cancel", "Cancel")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyEntity3198PickPostActionPickDTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3092/view/myexample3072inlinecreatelist"
                                    ));
                        })
                        .withoutAutoSaveBefore()
                )
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
// --8<-- [end:getActions]


}