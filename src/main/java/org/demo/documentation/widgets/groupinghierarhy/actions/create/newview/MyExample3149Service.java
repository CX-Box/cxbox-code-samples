package org.demo.documentation.widgets.groupinghierarhy.actions.create.newview;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.CxboxMyExample3148Controller;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.newview.MyEntity3167;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.newview.MyExample3167DTO;
import org.springframework.stereotype.Service;

@Service
public class MyExample3149Service extends VersionAwareResponseService<MyExample3149DTO, MyEntity3149> {

    private final MyEntity3149Repository repository;

    public MyExample3149Service(MyEntity3149Repository repository) {
        super(MyExample3149DTO.class, MyEntity3149.class, null, MyExample3149Meta.class);
        this.repository = repository;
    }

    // --8<-- [start:doCreateEntity]
    @Override
    protected CreateResult<MyExample3149DTO> doCreateEntity(MyEntity3149 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity))
                .setAction(PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample3148/view/myexample3149form/"
                                + CxboxMyExample3148Controller.myexample3149 + "/"
                                + entity.getId()));
    }
    // --8<-- [end:doCreateEntity]

    @Override
    protected ActionResultDTO<MyExample3149DTO> doUpdateEntity(MyEntity3149 entity, MyExample3149DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3149DTO_.customFieldText, entity::setCustomFieldText);
        setIfChanged(data, MyExample3149DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3149DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3149DTO> getActions() {
        return Actions.<MyExample3149DTO>builder()
                .create(crt -> crt.text("Add"))
                .action(act -> act
                        .action("finish", "Save and Close")
                        .invoker((bc, dto) -> {
                            MyEntity3149 myEntity = repository.getById(bc.getIdAsLong());
                            repository.save(myEntity);
                            return new ActionResultDTO<MyExample3149DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3148/view/myexample3149gh"
                                    ));
                        })
                )
                .build();
    }
    // --8<-- [end:getActions]

}
