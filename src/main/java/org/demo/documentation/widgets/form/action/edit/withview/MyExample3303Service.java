package org.demo.documentation.widgets.form.action.edit.withview;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.form.action.create.withview.MyEntity3302;
import org.demo.documentation.widgets.form.action.create.withview.MyExample3302DTO;
import org.demo.documentation.widgets.list.actions.create.newview.CxboxMyExample3066Controller;
import org.demo.documentation.widgets.list.actions.edit.newview.CxboxMyExample3075Controller;
import org.demo.documentation.widgets.list.actions.edit.newview.MyExample3075DTO;
import org.springframework.stereotype.Service;

@Service
public class MyExample3303Service extends VersionAwareResponseService<MyExample3303DTO, MyEntity3303> {

    private final MyEntity3303Repository repository;

    public MyExample3303Service(MyEntity3303Repository repository) {
        super(MyExample3303DTO.class, MyEntity3303.class, null, MyExample3303Meta.class);
        this.repository = repository;
    }

    // --8<-- [start:doCreateEntity]
    @Override
    protected CreateResult<MyExample3303DTO> doCreateEntity(MyEntity3303 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doCreateEntity]

    @Override
    protected ActionResultDTO<MyExample3303DTO> doUpdateEntity(MyEntity3303 entity, MyExample3303DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3303DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3303DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3303DTO> getActions() {
        return Actions.<MyExample3303DTO>builder()
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .action(act -> act
                        .scope(ActionScope.RECORD)
                        .withAutoSaveBefore()
                        .action("edit", "Edit")
                        .invoker((bc, data) -> new ActionResultDTO<MyExample3303DTO>()
                                .setAction(PostAction.drillDown(
                                        DrillDownType.INNER,
                                        "/screen/myexample3303/view/myexample3303formedit/"
                                                + CxboxMyExample3303Controller.myexample3303 + "/"
                                                + bc.getId()
                                ))))
                .action(act -> act
                        .action("finish", "Save and Close")
                        .invoker((bc, data) -> {
                                    MyEntity3303 myEntity = repository.getById(bc.getIdAsLong());
                                    repository.save(myEntity);
                                    return new ActionResultDTO<MyExample3303DTO>().setAction(
                                            PostAction.drillDown(
                                                    DrillDownType.INNER,
                                                    "/screen/myexample3303/view/myexample3303form"
                                            ));
                                }
                        ))
                .build();


    }


}
