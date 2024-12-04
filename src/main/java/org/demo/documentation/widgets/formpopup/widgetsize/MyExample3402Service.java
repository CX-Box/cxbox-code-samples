package org.demo.documentation.widgets.formpopup.widgetsize;

import lombok.NonNull;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.extention.action.ActionsExt;
import org.springframework.stereotype.Service;

@Service
public class MyExample3402Service extends VersionAwareResponseService<MyExample3402DTO, MyEntity3402> {

    private final MyEntity3402Repository repository;

    public MyExample3402Service(MyEntity3402Repository repository) {
        super(MyExample3402DTO.class, MyEntity3402.class, null, MyExample3402Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3402DTO> doCreateEntity(MyEntity3402 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3402DTO> doUpdateEntity(MyEntity3402 entity, MyExample3402DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3402DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    private static PreAction formPopup6(@NonNull String actionText) {
        return ActionsExt.confirmWithCustomWidget(actionText, "MyExample3402Formpopup6", "Done", "Cancel");
    }

    private static PreAction formPopup12(@NonNull String actionText) {
        return ActionsExt.confirmWithCustomWidget(actionText, "MyExample3402Formpopup12", "Done", "Cancel");
    }
    private static PreAction formPopup24(@NonNull String actionText) {
        return ActionsExt.confirmWithCustomWidget(actionText , "MyExample3402Formpopup24", "Done", "Cancel");
    }

    @Override
    public Actions<MyExample3402DTO> getActions() {
        return Actions.<MyExample3402DTO>builder()
                .action(act -> act
                        .action("form-popup6", "See formPopup6")
                        .withPreAction(formPopup6("Widget formPopup6"))
                        .invoker((bc, data) -> withApproval())
                )
                .action(act -> act
                        .action("form-popup12", "See formPopup12")
                        .withPreAction(formPopup12("Widget formPopup12"))
                        .invoker((bc, data) -> withApproval())
                )
                .action(act -> act
                        .action("form-popup24", "See formPopup24")
                        .withPreAction(formPopup24("Widget formPopup24"))
                        .invoker((bc, data) -> withApproval())
                )
                .build();
    }

    private ActionResultDTO<MyExample3402DTO> withApproval() {
        return new ActionResultDTO<>();
    }
}
