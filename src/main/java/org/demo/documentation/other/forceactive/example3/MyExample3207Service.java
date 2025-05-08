package org.demo.documentation.other.forceactive.example3;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3207Service extends VersionAwareResponseService<MyExample3207DTO, MyEntity3207> {

    private final MyEntity3207Repository repository;

    public MyExample3207Service(MyEntity3207Repository repository) {
        super(MyExample3207DTO.class, MyEntity3207.class, null, MyExample3207Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3207DTO> doCreateEntity(MyEntity3207 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3207DTO> doUpdateEntity(MyEntity3207 entity, MyExample3207DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3207DTO_.customFieldCheckBox, entity::setCustomFieldCheckBox);
        if (data.isFieldChanged(MyExample3207DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3207DTO> getActions() {
        return Actions.<MyExample3207DTO>builder()
                .addGroup(
                        "actions",
                        "Actions",
                        0,
                        Actions.<MyExample3207DTO>builder()
                                .action(act -> act
                                        .action("edit", "Edit")
                                        .withoutAutoSaveBefore()
                                        .invoker((bc, data) -> {
                                            return new ActionResultDTO<MyExample3207DTO>()
                                                    .setAction(PostAction.drillDown(
                                                            DrillDownType.INNER,
                                                            "/screen/myexample3207/view/myexample3207form/"
                                                                    + CxboxMyExample3207Controller.myexample3207 + "/"
                                                                    + bc.getId()
                                                    ));
                                        })).build()
                )
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

