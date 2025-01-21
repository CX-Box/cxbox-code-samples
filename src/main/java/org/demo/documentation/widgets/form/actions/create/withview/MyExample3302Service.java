package org.demo.documentation.widgets.form.actions.create.withview;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3302Service extends VersionAwareResponseService<MyExample3302DTO, MyEntity3302> {

    private final MyEntity3302Repository repository;

    public MyExample3302Service(MyEntity3302Repository repository) {
        super(MyExample3302DTO.class, MyEntity3302.class, null, MyExample3302Meta.class);
        this.repository = repository;
    }

    // --8<-- [start:doCreateEntity]
    @Override
    protected CreateResult<MyExample3302DTO> doCreateEntity(MyEntity3302 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity))
                .setAction(PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample3302/view/myexample3302formcreate/"
                                + CxboxMyExample3302Controller.myexample3302 + "/"
                                + entity.getId()));
    }
    // --8<-- [end:doCreateEntity]

    @Override
    protected ActionResultDTO<MyExample3302DTO> doUpdateEntity(MyEntity3302 entity, MyExample3302DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3302DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3302DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3302DTO> getActions() {
        return Actions.<MyExample3302DTO>builder()
                .create(crt -> crt.text("Add"))
                .action(act -> act
                        .action("cancel", "Cancel")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3302DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3302/view/myexample3302form"
                                    ));
                        })
                        .withoutAutoSaveBefore()
                )
                .action(act -> act
                        .action("finish", "Save and Close")
                        .invoker((bc, data) -> {
                                    MyEntity3302 myEntity = repository.getById(bc.getIdAsLong());
                                    repository.save(myEntity);
                                    return new ActionResultDTO<MyExample3302DTO>().setAction(
                                            PostAction.drillDown(
                                                    DrillDownType.INNER,
                                                    "/screen/myexample3302/view/myexample3302form"
                                            ));
                                }
                        ))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

}

