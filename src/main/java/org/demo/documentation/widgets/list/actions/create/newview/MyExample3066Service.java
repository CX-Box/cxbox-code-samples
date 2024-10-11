package org.demo.documentation.widgets.list.actions.create.newview;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;

import org.demo.documentation.widgets.list.actions.edit.newview.MyEntity3075;
import org.springframework.stereotype.Service;


@Service
public class MyExample3066Service extends VersionAwareResponseService<MyExample3066DTO, MyEntity3066> {

    private final MyEntity3066Repository repository;

    public MyExample3066Service(MyEntity3066Repository repository) {
        super(MyExample3066DTO.class, MyEntity3066.class, null, MyExample3066Meta.class);
        this.repository = repository;
    }
    // --8<-- [start:doCreateEntity]
    @Override
    protected CreateResult<MyExample3066DTO> doCreateEntity(MyEntity3066 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity))
                .setAction(PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample3066/view/myexample3066form/"
                                + CxboxMyExample3066Controller.myexample3066 + "/"
                                + entity.getId()));
    }
    // --8<-- [end:doCreateEntity]

    @Override
    protected ActionResultDTO<MyExample3066DTO> doUpdateEntity(MyEntity3066 entity, MyExample3066DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3066DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3066DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3066DTO> getActions() {
        return Actions.<MyExample3066DTO>builder()
                .create(crt -> crt.text("Add"))
                .action(act -> act
                        .action("finish", "Save and Close")
                        .invoker((bc, dto) -> {
                            MyEntity3066 myEntity = repository.getById(bc.getIdAsLong());
                            repository.save(myEntity);
                            return new ActionResultDTO<MyExample3066DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3066/view/myexample3066list"
                                    ));
                        })
                )
                .build();
    }
     // --8<-- [end:getActions]


    @Override
    public ActionResultDTO<MyExample3066DTO> onCancel(BusinessComponent bc) {
        return new ActionResultDTO<MyExample3066DTO>().setAction(
                PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample3066/view/myexample3066list"
                ));
    }

}
