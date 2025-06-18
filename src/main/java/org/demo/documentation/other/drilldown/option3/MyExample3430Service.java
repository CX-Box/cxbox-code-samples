package org.demo.documentation.other.drilldown.option3;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.drilldown.option.CxboxMyExample3421Controller;
import org.springframework.stereotype.Service;

@Service
public class MyExample3430Service extends VersionAwareResponseService<MyExample3430DTO, MyEntity3430> {

    private final MyEntity3430Repository repository;

    public MyExample3430Service(MyEntity3430Repository repository) {
        super(MyExample3430DTO.class, MyEntity3430.class, null, MyExample3430Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3430DTO> doCreateEntity(MyEntity3430 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity))
                .setAction(PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample3421/view/myexample3430form/"
                                + CxboxMyExample3430Controller.myexample3430));
    }

    @Override
    protected ActionResultDTO<MyExample3430DTO> doUpdateEntity(MyEntity3430 entity, MyExample3430DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3430DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3430DTO> getActions() {
        return Actions.<MyExample3430DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

