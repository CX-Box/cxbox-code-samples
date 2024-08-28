package org.demo.documentation.widgets.list.actions.create.newview;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.customization.icon.ActionIcon;
import org.springframework.stereotype.Service;

@Service
public class MyExample3066Service extends VersionAwareResponseService<MyExample3066DTO, MyEntity3066> {

    private final MyEntity3066Repository repository;

    public MyExample3066Service(MyEntity3066Repository repository) {
        super(MyExample3066DTO.class, MyEntity3066.class, null, MyExample3066Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3066DTO> doCreateEntity(MyEntity3066 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3066DTO> doUpdateEntity(MyEntity3066 entity, MyExample3066DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3066DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3066DTO> getActions() {
        return Actions.<MyExample3066DTO>builder()
                .newAction()
                .add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .create().text("Add").add()
                .addGroup(
                        "actions",
                        "Actions",
                        0,
                        Actions.<MyExample3066DTO>builder()
                                .newAction()
                                .action("edit", "Edit")
                                .withoutAutoSaveBefore()
                                .invoker((bc, data) -> {
                                    MyEntity3066 client = repository.getById(bc.getIdAsLong());
                                    return new ActionResultDTO<MyExample3066DTO>()
                                            .setAction(PostAction.drillDown(
                                                    DrillDownType.INNER,
                                                    "/screen/myexample3066/view/myexample3066list/"
                                                            + CxboxMyExample3066Controller.myexample3066 + "/"
                                                            + bc.getId()
                                            ));
                                }).add().build()
                ).withIcon(ActionIcon.MENU, false)
                .build();
    }


}

