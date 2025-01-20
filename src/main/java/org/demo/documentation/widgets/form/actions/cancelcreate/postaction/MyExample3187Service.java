package org.demo.documentation.widgets.form.actions.cancelcreate.postaction;

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
public class MyExample3187Service extends VersionAwareResponseService<MyExample3187DTO, MyEntity3187> {

    private final MyEntity3187Repository repository;

    public MyExample3187Service(MyEntity3187Repository repository) {
        super(MyExample3187DTO.class, MyEntity3187.class, null, MyExample3187Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3187DTO> doCreateEntity(MyEntity3187 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3187DTO> doUpdateEntity(MyEntity3187 entity, MyExample3187DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3187DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3187DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3187DTO> getActions() {
        return Actions.<MyExample3187DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .action(act -> act
                        .action("cancel", "Cancel")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3187DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3187"
                                    ));
                        })
                        .withoutAutoSaveBefore()
                )
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("finish", "Save and Close")
                        .invoker((bc, data) -> {
                                    MyEntity3187 myEntity = repository.getById(bc.getIdAsLong());
                                    repository.save(myEntity);
                                    return new ActionResultDTO<MyExample3187DTO>().setAction(
                                            PostAction.drillDown(
                                                    DrillDownType.INNER,
                                                    "/screen/myexample3187/view/myexample3187form"
                                            ));
                                }
                        ))
                .build();
    }
    // --8<-- [end:getActions]

}

