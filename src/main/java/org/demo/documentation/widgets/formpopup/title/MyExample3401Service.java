package org.demo.documentation.widgets.formpopup.title;

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
public class MyExample3401Service extends VersionAwareResponseService<MyExample3401DTO, MyEntity3401> {

    private final MyEntity3401Repository repository;

    public MyExample3401Service(MyEntity3401Repository repository) {
        super(MyExample3401DTO.class, MyEntity3401.class, null, MyExample3401Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3401DTO> doCreateEntity(MyEntity3401 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3401DTO> doUpdateEntity(MyEntity3401 entity, MyExample3401DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample3401DTO_.customField2)) {
        entity.setCustomField2(data.getCustomField2());
      }
      if (data.isFieldChanged(MyExample3401DTO_.customField)) {
        entity.setCustomField(data.getCustomField());
      }

      return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    private static PreAction seeConstantTitle(@NonNull String actionText) {
        return ActionsExt.confirmWithCustomWidget(actionText + "?", "MyExample3401Formpopup", "Done", "Cancel");
    }
    private static PreAction seeCustomTitle(@NonNull String actionText) {
        return ActionsExt.confirmWithCustomWidget(actionText + "?", "MyExample3401FormpopupCustomTitle", "Done", "Cancel");
    }
    @Override
    public Actions<MyExample3401DTO> getActions() {
        return Actions.<MyExample3401DTO>builder()
                .newAction()
                .action("see-constant-title", "See constant title")
                .withPreAction(seeConstantTitle("See constant title "))
                .invoker((bc, data) -> withApproval())
                .add()
                .newAction()
                .action("see-custom-title", "See custom title")
                .withPreAction(seeCustomTitle("Custom Title - value field"))
                .invoker((bc, data) -> withApproval())
                .add()
                .build();
    }
    private ActionResultDTO<MyExample3401DTO> withApproval() {
        return new ActionResultDTO<>();
    }


}