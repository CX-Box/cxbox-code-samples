package org.demo.documentation.other.forceactive.example2;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3205Service extends VersionAwareResponseService<MyExample3205DTO, MyEntity3205> {

    private final MyEntity3205Repository repository;

    public MyExample3205Service(MyEntity3205Repository repository) {
        super(MyExample3205DTO.class, MyEntity3205.class, null, MyExample3205Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3205DTO> doCreateEntity(MyEntity3205 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3205DTO> doUpdateEntity(MyEntity3205 entity, MyExample3205DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3205DTO_.customFieldCheckBox, entity::setCustomFieldCheckBox);
        if (data.isFieldChanged(MyExample3205DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3205DTO> getActions() {
        return Actions.<MyExample3205DTO>builder()
                .addGroup(
                        "actions",
                        "Actions",
                        0,
                        Actions.<MyExample3205DTO>builder()
                                .action(act -> act
                                        .action("edit", "Edit")
                                        .withoutAutoSaveBefore()
                                        .invoker((bc, data) -> {
                                            return new ActionResultDTO<MyExample3205DTO>()
                                                    .setAction(PostAction.drillDown(
                                                            DrillDownType.INNER,
                                                            "/screen/myexample3205/view/myexample3205form/"
                                                                    + CxboxMyExample3205Controller.myexample3205 + "/"
                                                                    + bc.getId()
                                                    ));
                                        })).build()
                )
                .build();
    }


}

