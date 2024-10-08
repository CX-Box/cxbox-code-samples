package org.demo.documentation.widgets.form.action.edit.withview;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.list.actions.create.newview.CxboxMyExample3066Controller;
import org.springframework.stereotype.Service;

@Service
public class MyExample3303Service extends VersionAwareResponseService<MyExample3303DTO, MyEntity3303> {

    private final MyEntity3303Repository repository;

    public MyExample3303Service(MyEntity3303Repository repository) {
        super(MyExample3303DTO.class, MyEntity3303.class, null, MyExample3303Meta.class);
        this.repository = repository;
    }

    // --8<-- [start:doCreateEntity]
    @Override
    protected CreateResult<MyExample3303DTO> doCreateEntity(MyEntity3303 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity))
                .setAction(PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample3303/view/myexample3303formcreate/"
                                + CxboxMyExample3303Controller.myexample3303 + "/"
                                + entity.getId()));
    }
    // --8<-- [end:doCreateEntity]

    @Override
    protected ActionResultDTO<MyExample3303DTO> doUpdateEntity(MyEntity3303 entity, MyExample3303DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3303DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3303DTO> getActions() {
        return Actions.<MyExample3303DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

