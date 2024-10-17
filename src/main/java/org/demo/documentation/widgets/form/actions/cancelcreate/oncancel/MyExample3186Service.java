package org.demo.documentation.widgets.form.actions.cancelcreate.oncancel;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3186Service extends VersionAwareResponseService<MyExample3186DTO, MyEntity3186> {

    private final MyEntity3186Repository repository;

    public MyExample3186Service(MyEntity3186Repository repository) {
        super(MyExample3186DTO.class, MyEntity3186.class, null, MyExample3186Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3186DTO> doCreateEntity(MyEntity3186 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity))
                .setAction(PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample3186/view/myexample3186formcreate/"
                                + CxboxMyExample3186Controller.myexample3186 + "/"
                                + entity.getId()));
    }

    @Override
    protected ActionResultDTO<MyExample3186DTO> doUpdateEntity(MyEntity3186 entity, MyExample3186DTO data, BusinessComponent bc) {
      setIfChanged(data, MyExample3186DTO_.customFieldText, entity::setCustomFieldText);
      if (data.isFieldChanged(MyExample3186DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

  // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3186DTO> getActions() {
        return Actions.<MyExample3186DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("finish", "Save and Close")
                        .invoker((bc, data) -> {
                                    MyEntity3186 myEntity = repository.getById(bc.getIdAsLong());
                                    repository.save(myEntity);
                                    return new ActionResultDTO<MyExample3186DTO>().setAction(
                                            PostAction.drillDown(
                                                    DrillDownType.INNER,
                                                    "/screen/myexample3186/view/myexample3186form"
                                            ));
                                }
                        ))
                .build();
    }
  // --8<-- [end:getActions]

  // --8<-- [start:onCancel]
  @Override
  public ActionResultDTO onCancel(BusinessComponent bc) {
    return new ActionResultDTO<>().setAction(PostAction.drillDown(
            DrillDownType.INNER,
            "/screen/myexample3186/"
    ));
  }
  // --8<-- [end:onCancel]
}

