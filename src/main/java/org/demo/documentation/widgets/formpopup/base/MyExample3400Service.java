package org.demo.documentation.widgets.formpopup.base;

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
public class MyExample3400Service extends VersionAwareResponseService<MyExample3400DTO, MyEntity3400> {

    private final MyEntity3400Repository repository;

    public MyExample3400Service(MyEntity3400Repository repository) {
        super(MyExample3400DTO.class, MyEntity3400.class, null, MyExample3400Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3400DTO> doCreateEntity(MyEntity3400 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3400DTO> doUpdateEntity(MyEntity3400 entity, MyExample3400DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3400DTO_.customField2)) {
            entity.setCustomField2(data.getCustomField2());
        }
        if (data.isFieldChanged(MyExample3400DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    private static PreAction confirmWithComment(@NonNull String actionText) {
        return ActionsExt.confirmWithCustomWidget(actionText + "?", "MyExample3400Formpopup", "Done", "Cancel");
    }

    @Override
    public Actions<MyExample3400DTO> getActions() {
        return Actions.<MyExample3400DTO>builder()
                .newAction()
                .action("save-send", "Save and send on approval")
                .withPreAction(confirmWithComment("Save and send on approval"))
                .invoker((bc, data) -> withApproval())
                .add()
                .build();
    }
    private ActionResultDTO<MyExample3400DTO> withApproval() {
        return new ActionResultDTO<>();
    }

}