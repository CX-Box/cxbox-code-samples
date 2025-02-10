package org.demo.documentation.widgets.picklist.actions.cancelcreate.oncancel;

import lombok.Getter;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.basic.MyEntity3198Pick;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.basic.MyEntity3198PickPickDTO;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.basic.MyEntity3198PickRepository;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3198PickOnCancelPickService extends VersionAwareResponseService<MyEntity3198PickOnCancelPickDTO, MyEntity3198PickOnCancel> {
    private final MyEntity3198PickOnCancelRepository repository;

    public MyEntity3198PickOnCancelPickService(MyEntity3198PickOnCancelRepository repository) {
        super(MyEntity3198PickOnCancelPickDTO.class, MyEntity3198PickOnCancel.class, null, MyEntity3198PickOnCancelPickMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3198PickOnCancelPickDTO> doCreateEntity(MyEntity3198PickOnCancel entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }


    @Override
    protected ActionResultDTO<MyEntity3198PickOnCancelPickDTO> doUpdateEntity(MyEntity3198PickOnCancel entity, MyEntity3198PickOnCancelPickDTO data,
                                                                              BusinessComponent bc) {
        setIfChanged(data, MyEntity3198PickOnCancelPickDTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3198PickOnCancelPickDTO> getActions() {
        return Actions.<MyEntity3198PickOnCancelPickDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

    // --8<-- [start:onCancel]
    @Override
    public ActionResultDTO onCancel(BusinessComponent bc) {
        return new ActionResultDTO<>().setAction(PostAction.drillDown(
                DrillDownType.INNER,
                "/screen/myexample3092/view/myexample3072inlinecreatelist"
        ));
    }
    // --8<-- [end:onCancel]
}