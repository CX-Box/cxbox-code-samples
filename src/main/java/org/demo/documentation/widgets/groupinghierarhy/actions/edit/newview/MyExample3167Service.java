package org.demo.documentation.widgets.groupinghierarhy.actions.edit.newview;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.CxboxMyExample3166Controller;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3167Service extends VersionAwareResponseService<MyExample3167DTO, MyEntity3167> {

    private final MyEntity3167Repository repository;

    public MyExample3167Service(MyEntity3167Repository repository) {
        super(MyExample3167DTO.class, MyEntity3167.class, null, MyExample3167Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3167DTO> doCreateEntity(MyEntity3167 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity))
                .setAction(PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample31466/view/myexample3167form/"
                                + CxboxMyExample3166Controller.myexample3167 + "/"
                                + entity.getId()));
    }
    // --8<-- [end:doCreateEntity]
    @Override
    protected ActionResultDTO<MyExample3167DTO> doUpdateEntity(MyEntity3167 entity, MyExample3167DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3167DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3167DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3167DTO> getActions() {
        return Actions.<MyExample3167DTO>builder()
                .create(crt -> crt.text("Add"))
                .action(act -> act
                        .action("finish", "Save and Close")
                        .invoker((bc, dto) -> {
                            MyEntity3167 myEntity = repository.getById(bc.getIdAsLong());
                            repository.save(myEntity);
                            return new ActionResultDTO<MyExample3167DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3166/view/myexample3167gh"
                                    ));
                        })
                )
                .addGroup(
                        "actions",
                        "Actions",
                        0,
                        Actions.<MyExample3167DTO>builder()
                                .action(act -> act
                                        .action("edit", "Edit")
                                        .withoutAutoSaveBefore()
                                        .invoker((bc, data) -> {
                                            return new ActionResultDTO<MyExample3167DTO>()
                                                    .setAction(PostAction.drillDown(
                                                            DrillDownType.INNER,
                                                            "/screen/myexample3166/view/myexample3167form/"
                                                                    + CxboxMyExample3166Controller.myexample3167 + "/"
                                                                    + bc.getId()
                                                    ));
                                        })).build()
                )
                .build();
    }


}

