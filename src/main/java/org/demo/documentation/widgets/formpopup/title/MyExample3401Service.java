package org.demo.documentation.widgets.formpopup.title;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3401Service extends VersionAwareResponseService<MyExample3401DTO, MyEntity3401> {

    private final MyEntity3401Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3401Meta> meta = MyExample3401Meta.class;

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

    @Override
    public Actions<MyExample3401DTO> getActions() {
        return Actions.<MyExample3401DTO>builder()
                .action(act -> act
                        .action("see-constant-title", "See constant title")
                        .withPreAction(PreAction.confirmWithWidget("MyExample3401Formpopup", cfw -> cfw))
                        .invoker((bc, dto) -> new ActionResultDTO<MyExample3401DTO>())

                )
                .action(act -> act
                        .action("see-custom-title", "See custom title")
                        .withPreAction(PreAction.confirmWithWidget("MyExample3401FormpopupCustomTitle", cfw -> cfw))
                        .invoker((bc, dto) -> new ActionResultDTO<MyExample3401DTO>())

                )
                .build();
    }

}